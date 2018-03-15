
$(function () {
    laydate.render({elem: '#meaTime', value: new Date()});
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
            $("#pciCellDiv").css("display", "");
        } else {
            $("#pciCellDiv").css("display", "none");
        }
    });

    $("#config").change(function () {
        if($("#config").find("option:selected").val() === 'default') {
            $("#configDiv").css("display", "none");
        } else {
            $("#configDiv").css("display", "");
        }
    });

    $("#submitTask").click(function () {
        if(!checkTaskInfoSubmit()) {
            return false;
        } else {
            showInfoInAndOut("success", "任务已提交，请稍候");
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

    $("#downloadBtn").click(function () {
        downloadResult();
    })

});

//初始工作
function init() {
    getArea();
    getThreshold();
    getTaskDetail();
}

//获取任务列表
function getTaskDetail() {
    $.ajax({
        url : "/api/pci-afp/task-detail",
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
            "data": data,
            "columns": [
                { "data" : "jobName" },
                {"data": "runningStatus"},
                { "data" : "cityName" },
                { "data" : null },
                { "data" : "launchTime" },
                { "data" : "completeTime" },
                { "data" : null }
            ],
            "columnDefs": [
                {
                    "render": function(data, type, row) {
                        return row.begMeaTime + " 至 " + row.endMeaTime;
                    },
                    "targets": 3,
                    "data": null
                },
                {
                    "render": function(data, type, row) {
                        if(row.jobRunningStatus === '正常完成') {
                            return "<button class='btn btn-info table-btn' onclick='queryReport(" + row.jobId + ")'" +
                                " type='button'><i class='glyphicon glyphicon-comment'> 查看报告</i></button>" +
                            "<button class='btn btn-success table-btn' onclick='queryResult("+ row.jobId + ")'" +
                            " type='button'><i class='glyphicon glyphicon-list-alt'> 查看结果</i></button></div>";
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
            "searching": false,
            "info": true,
            "destroy": true,
            "language": {
                url: '/lib/datatables/1.10.16/i18n/Chinese.json'
            }
        });
        showInfoInAndOut('success', '加载完成！');
    }
}

//提示信息淡入淡出
function showInfoInAndOut(div, info) {
    var element = $("#" + div);
    element.html(info);
    element.fadeIn(1000);
    setTimeout("$('#" + div + "').fadeOut(2000)", 3000);
}

//下载结果文件
function downloadResult() {
    var form = $("#downloadResultForm");
    form.attr("action", "/api/pci-afp/download-result");
    form.submit();
}

//查看结果
function queryResult(jobId) {
    $("#jobId").val(jobId);
    $.ajax({
        url : "/api/pci-afp/task-result",
        type: "POST",
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

//查看报告
function queryReport(jobId) {
    $("#jobId").val(jobId);
    $.ajax({
        url : "/api/pci-afp/task-report",
        type: "POST",
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
            "columns": [
                { "data" : "cellName" },
                { "data" : "cellId" },
                { "data" : "oldEarfcn" },
                { "data" : "newEarfcn" },
                { "data" : "oldPci" },
                { "data" : "newPci" },
                { "data" : "oldInterVal" },
                { "data" : "newInterVal" },
                { "data" : "remark" }
            ],
            "lengthChange": false,
            "ordering": true,
            "searching": false,
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
    $("#pciCellDiv").css("display", "");
    $("#configDiv").css("display", "none");
    $('#newTaskForm')[0].reset();
    laydate.render({elem: '#begMeaTime', value: new Date(new Date().getTime() - 7 * 86400000)});
    laydate.render({elem: '#endMeaTime', value: new Date()});
}

//获取地市
function getArea() {
    $.ajax({
        url : "/api/pci-afp/area",
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

//获取参数
function getThreshold() {
    $.ajax({
        url: '/api/pci-afp/threshold',
        dataType: 'json',
        type: 'GET',
        success: showThreshold
    });
}

//展示阈值表
function showThreshold(data) {
    if(data === "") {
        console.log('没有找到参数阈值！');
    }else {
        var tab = $('#thresholdTab').find('tbody');
        tab.html("");
        $.each(data, function (index, value) {
            if(value.code === 'CELLM3RINTERFERCOEF' ||  value.code === 'CELLM6RINTERFERCOEF' ||
            value.code === 'CELLM30RINTERFERCOEF' || value.code === 'INCREASETOPNCELLLIST' ||
            value.code === 'CONVERMETHOD2SCOREN') {
                tab.append("<tr id='" + value.code + "'><td>" + value.descInfo + "</td><td>" +
                    "<input type='text' class='form-control' onkeyup='value=value.replace(/[^.-\\d]/g,\"\")' "
                    + "min='-99999' max='99999' maxlength='7' name='" + value.code +"' value='" +
                    value.defaultVal + "'></td><td>" + value.scopeDesc + "</td></tr>");
            }else if(value.code === 'BEFORENSTRONGCELLTAB') {
                tab.append("<tr id='" + value.code + "'><td>" + value.descInfo + "</td><td>" +
                    "<input type='text' class='form-control' onkeyup='value=value.replace(/[^\\d]/g,\"\")' " +
                    "min='1' max='99999' name='" + value.code + "' value='" + value.defaultVal + "'>" +
                    "</td><td>" + value.scopeDesc + "</td></tr>");
            } else if(value.code === 'TOPNCELLLIST' || value.code === 'CONVERMETHOD1TARGETVAL' ||
            value.code === 'CONVERMETHOD2TARGETVAL') {
                tab.append("<tr id='" + value.code + "'><td>" + value.descInfo + "</td><td>" +
                    "<input type='text' class='form-control' onkeyup='value=value.replace(/[^\\d]/g,\"\")' " +
                    "min='1' max='100' name='" + value.code + "' value='" + value.defaultVal + "'>" +
                    "</td><td>" + value.scopeDesc + "</td></tr>");
            }
        })
    }
}

//提交任务
function submitTask() {
    $.ajax({
        url : "/api/pci-afp/submit-task",
        type: "POST",
        data: $("#newTaskForm").serialize(),
        success: showTaskDetail,
        error: function (err) {
            $("#loading").css("display", "none");
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
    var optimizeCells = $("#optimizeCells").val().trim();

    for (var i = 0; i < taskName.length; i++) { // 应用for循环语句,获取表单提交用户名字符串的长度
        if (taskName.charCodeAt(i) > 255) { // 判断如果长度大于255
            n += 2; // 则表示是汉字为2个字节
        } else {
            n += 1; // 否则表示是英文字符,为1个字节
        }
    }

    if($("#mode").find("option:selected").val() === 'input') {
        if (optimizeCells === null || optimizeCells === "") {
            showInfoInAndOut("warn", "请输入变PCI小区表");
            flagCells = false;
        } else if (!isNumCutByComma(optimizeCells)) {
            showInfoInAndOut("warn", "变PCI小区表应该是小区ID以逗号分隔的形式");
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
function isNumCutByComma(optimizeCells) {
    var flag = true;
    var reg = /^(\d{5,8}-\d{1,3})(,\d{5,9}-\d{1,3})*,?$/;
    if (!reg.test(optimizeCells)) {
        flag = false;
    }
    return flag;
}