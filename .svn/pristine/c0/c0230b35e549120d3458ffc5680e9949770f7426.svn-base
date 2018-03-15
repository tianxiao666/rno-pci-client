$(function () {
    laydate.render({elem: '#meaTime'});
    laydate.render({elem: '#startTime', value: new Date(new Date().getTime() - 7 * 86400000), type: 'datetime'});
    laydate.render({elem: '#endTime', value: new Date(), type: 'datetime'});

    init();

    $("#queryBtn").click(function () {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        if(startTime > endTime) {
            showInfoInAndOut("warn", "结束时间请勿早于开始时间！");
            return false;
        }
        $("#loading").css("display", "block");
        getTaskDetail();
    });

    $("#mode").change(function () {
        if($("#mode").find("option:selected").val() === 'input') {
            $("#evalCellDiv").css("display", "");
        } else {
            $("#evalCellDiv").css("display", "none");
        }
    });

    $("#submitTask").click(function () {
        if(!checkTaskInfoSubmit()) {
            return false;
        } else {
            submitTask();
        }
    });

    $("#resultBack").click(function () {
        $("#mainDiv").css("display", "");
        $("#resultDiv").css("display", "none");
    });

    $("#reportBack").click(function () {
        $("#mainDiv").css("display", "");
        $("#reportDiv").css("display", "none");
    });

    $("#enhancePlanBack").click(function () {
        $("#mainDiv").css("display", "");
        $("#enhancePlanDiv").css("display", "none");
    });

    $("#downloadResultBtn").click(function () {
        downloadResult();
    });

    $("#downloadEnhancePlanBtn").click(function () {
        downloadEnhancePlan();
    })

});

//初始工作
function init() {
    getArea();
    getTaskDetail();
}

//获取任务列表
function getTaskDetail() {
    $.ajax({
        url : "/api/azimuth-evaluation/task-detail",
        type: "POST",
        data: $("#queryForm").serialize(),
        success: showTaskDetail,
        error: function (err) {
            $("#loading").css("display", "none");
            showInfoInAndOut('error', '程序出错了！');
            console.log(err);
        }
    })
}

//展示任务列表
function showTaskDetail(data) {
    $("#loading").css("display", "none");
    if(data === "") {
        showInfoInAndOut('warn', '没有找到数据！');
    }else {
        // console.log(data);
        var tab = $('#taskResult');
        tab.DataTable({
            "pageLength": 5,
            "data": data,
            "order": [[ 4, "desc" ]],
            "columns": [
                {"data": "name"},
                { "data" : null },
                { "data" : "cityName" },
                { "data" : null },
                { "data" : "createTime" },
                { "data" : "completeTime" },
                { "data" : null }
            ],
            "columnDefs": [
                {
                    "render": function(data, type, row) {
                        if(row.jobRunningStatus === 'Running') {
                            return "运行中";
                        } else if(row.jobRunningStatus === 'Succeeded') {
                            return "正常完成";
                        } else if(row.jobRunningStatus === 'Fail') {
                            return "异常终止";
                        } else if(row.jobRunningStatus === 'Waiting') {
                            return "排队中";
                        } else if(row.jobRunningStatus === 'Stopping') {
                            return "停止中";
                        } else if(row.jobRunningStatus === 'Stopped') {
                            return "已停止";
                        }
                    },
                    "targets": 1,
                    "data": null
                },
                {
                    "render": function(data, type, row) {
                        if(row.begMeaTime !== null && row.begMeaTime !== "") {
                            return row.begMeaTime;
                        } else {
                            return "";
                        }
                    },
                    "targets": 3,
                    "data": null
                },
                {
                    "render": function(data, type, row) {
                        if(row.jobRunningStatus === 'Succeeded') {
                            return "<button class='btn btn-info table-btn' onclick='queryReport(" + row.jobId + ")'" +
                                " type='button'><i class='glyphicon glyphicon-comment'> 查看报告</i></button>" +
                                "<button class='btn btn-success table-btn' onclick='queryResult("+ row.jobId + ")'" +
                                " type='button'><i class='glyphicon glyphicon-list-alt'> 查看结果</i></button>" +
                                "<button class='btn btn-primary table-btn' onclick='queryEnhancePlan(" + row.jobId + ")' " +
                                "type='button'><i class='glyphicon glyphicon-folder-open'> 查看网络覆盖增强方案" +
                                "</i></button>";
                        } else {
                            return "<button class='btn btn-info' onclick='queryReport("+ row.jobId + ")'" +
                                " type='button'><i class='glyphicon glyphicon-comment'> 查看报告</i></button>";
                        }
                    },
                    "targets": 6,
                    "data": null
                }
            ],
            "lengthChange": false,
            "ordering": true,
            "searching": true,
            "info": true,
            "destroy": true,
            "language": {
                url: '/lib/datatables/1.10.16/i18n/Chinese.json'
            }
        });
    }
}

//提示信息淡入淡出
function showInfoInAndOut(div, info) {
    var element = $("#" + div);
    element.html(info);
    element.fadeIn(1000);
    setTimeout("$('#" + div + "').fadeOut(1000)", 2000);
}

//下载结果文件
function downloadResult() {
    var form = $("#downloadResultForm");
    form.attr("action", "/api/azimuth-evaluation/download-result");
    form.submit();
}

//下载网络覆盖增强方案
function downloadEnhancePlan() {
    var form = $("#downloadEnhancePlanForm");
    form.attr("action", "/api/azimuth-evaluation/download-enhance");
    form.submit();
}

//查看结果
function queryResult(jobId) {
    $("#id").val(jobId);
    $("#loading").css("display", "block");
    $.ajax({
        url : "/api/azimuth-evaluation/task-result",
        type: "GET",
        data: {
            jobId: jobId
        },
        success: showResultTab,
        error: function (err) {
            $("#loading").css("display", "none");
            showInfoInAndOut('error', '程序出错了！');
            console.log(err);
        }
    })
}

//查看网络覆盖增强方案
function queryEnhancePlan(jobId) {
    $("#jobId1").val(jobId);
    $("#loading").css("display", "block");
    $.ajax({
        url : "/api/azimuth-evaluation/enhance-plan",
        type: "GET",
        data: {
            jobId: jobId
        },
        success: showEnhancePlanTab,
        error: function (err) {
            $("#loading").css("display", "none");
            showInfoInAndOut('error', '程序出错了！');
            console.log(err);
        }
    })
}

//查看报告
function queryReport(jobId) {
    $("#id").val(jobId);
    $.ajax({
        url : "/api/azimuth-evaluation/task-report",
        type: "GET",
        data: {
            jobId: jobId
        },
        success: showReportTab,
        error: function (err) {
            $("#loading").css("display", "none");
            showInfoInAndOut('error', '程序出错了！');
            console.log(err);
        }
    })
}

//展示网络覆盖增强方案表
function showEnhancePlanTab(data) {
    $("#loading").css("display", "none");
    if(data === "") {
        showInfoInAndOut('warn', '没有找到数据！');
    }else {
        // console.log(data);
        $("#mainDiv").css("display", "none");
        $("#enhancePlanDiv").css("display", "");
        var tab = $('#enhancePlanTab');
        tab.DataTable({
            "data": data,
            "order": [[ 1, "desc" ]],
            "columns": [
                { "data" : "name" },
                { "data" : "cell_id" },
                { "data" : "cell_name" },
                { "data" : "result" }
            ],
            "lengthChange": false,
            "ordering": true,
            "searching": true,
            "info": true,
            "destroy": true,
            "language": {
                url: '/lib/datatables/1.10.16/i18n/Chinese.json'
            }
        });
        showInfoInAndOut('success', '加载完成！');
    }
}

//展示报告表
function showReportTab(data) {
    if(data === "") {
        console.log('没有找到报告！');
    }else {
        $("#mainDiv").css("display", "none");
        $("#reportDiv").css("display", "");
        var tab = $('#reportTab').find('tbody');
        tab.html("");
        $.each(data, function (index, value) {
            tab.append("<tr><td>" + value.stage + "</td><td>" + value.startTime + "</td>" +
                "<td>" + value.endTime + "</td><td>" + value.result +
                "</td><td>" + value.detail + "</td></tr>");
        })
    }
}

//展示结果表
function showResultTab(data) {
    $("#loading").css("display", "none");
    if(data === "") {
        showInfoInAndOut('warn', '没有找到数据！');
    }else {
        // console.log(data);
        $("#mainDiv").css("display", "none");
        $("#resultDiv").css("display", "");
        var tab = $('#resultTab');
        tab.DataTable({
            "data": data,
            "order": [[ 1, "desc" ]],
            "columns": [
                { "data" : "name" },
                { "data" : "cell_id" },
                { "data" : "cell_name" },
                { "data" : "azimuth" },
                { "data" : "azimuth1" },
                { "data" : "diff" }
            ],
            "lengthChange": false,
            "ordering": true,
            "searching": true,
            "info": true,
            "destroy": true,
            "language": {
                url: '/lib/datatables/1.10.16/i18n/Chinese.json'
            }
        });
        showInfoInAndOut('success', '加载完成！');
    }
}

//模态框展示前准备工作
function showModal() {
    $("#evalCellDiv").css("display", "");
    $('#newTaskForm')[0].reset();
    laydate.render({elem: '#begMeaTime', value: new Date(new Date().getTime() - 7 * 86400000)});
    laydate.render({elem: '#endMeaTime', value: new Date()});
}

//获取地市
function getArea() {
    $.ajax({
        url : "/api/azimuth-evaluation/area",
        type: "GET",
        async: false,
        success: function (data) {
            $.each(data, function (index, value) {
                $("#cityId").append("<option value='"+ value.id +"'>" + value.name + "</option>");
                $("#cityId1").append("<option value='"+ value.id +"'>" + value.name + "</option>");
            })
        }
    });
}

//提交任务
function submitTask() {
    $.ajax({
        url : "/api/azimuth-evaluation/submit-task",
        type: "POST",
        data: $("#newTaskForm").serialize(),
        beforeSend: function () {
            showInfoInAndOut("info", "正在提交任务");
        },
        success: function (data) {
            if (data.flag === false) {
                showInfoInAndOut("info", data.result);
            } else {
                showInfoInAndOut("success", "任务提交成功，请等待分析完成！");
                getTaskDetail();
            }
        },
        error: function (err) {
            showInfoInAndOut('error', '程序出错了！');
            console.log(err);
        }
    })
}

//对提交分析任务的信息作验证
function checkTaskInfoSubmit() {
    var n = 0;
    var flagName = true;
    var flagCells = true;

    var taskName = $.trim($("#taskName1").val());
    var assessmentCells = $("#evaluationCells").val().trim();

    for (var i = 0; i < taskName.length; i++) { // 应用for循环语句,获取表单提交用户名字符串的长度
        if (taskName.charCodeAt(i) > 255) { // 判断如果长度大于255
            n += 2; // 则表示是汉字为2个字节
        } else {
            n += 1; // 否则表示是英文字符,为1个字节
        }
    }

    if($("#mode").find("option:selected").val() === 'input') {
        if (assessmentCells === null || assessmentCells === "") {
            showInfoInAndOut("warn", "请输入评估小区表");
            flagCells = false;
        } else if (!isNumCutByComma(assessmentCells)) {
            showInfoInAndOut("warn", "评估小区表应该是小区ID以逗号分隔的形式");
            flagCells = false;
        }
    }

    // 验证任务名称
    if (ifHasSpecChar(taskName, "[~'!@#$%^&*+=]")) {
        showInfoInAndOut("warn", "任务名称请勿包含特殊字符:~'!@#$%^&*+=");
        flagName = false;
    }
    if (n > 25) {
        showInfoInAndOut("warn", "任务名称请勿超过25个字符");
        flagName = false;
    } else if (n === 0) {
        showInfoInAndOut("warn", "请输入任务名称");
        flagName = false;
    }

    return flagName && flagCells;
}

//测试是否包含特殊字符
function ifHasSpecChar(str, regExp) {
    var pattern = new RegExp(regExp);
    return pattern.test(str);
}


//是否以逗号分割的数字，允许逗号结尾
function isNumCutByComma(assessmentCells) {
    var flag = true;
    var reg = /^(\d{5,8}-\d{1,3})(,\d{5,9}-\d{1,3})*,?$/;
    if (!reg.test(assessmentCells)) {
        flag = false;
    }
    return flag;
}