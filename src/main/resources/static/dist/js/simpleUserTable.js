function getBaseUrl() {
    var href = window.location.href;
    var index = 0;
    var counter = 0;
    for (var i = 0; i < href.length; i++) {
        if (href.charAt(i) == '/') {
            counter++
        }
        if (counter == 3) {
            index = i;
            break;
        }
    }
    return href.substring(0, index);
}

var baseUrl = getBaseUrl();

$(function () {
    $("#logout").click(function () {
        this.href = baseUrl + "/logout";
    });
});

$(function () {

    $('#side-menu').metisMenu();

});

//Loads the correct sidebar on window load,
//collapses the sidebar on window resize.
// Sets the min-height of #page-wrapper to window size
$(function () {
    $(window).bind("load resize", function () {
        topOffset = 50;
        width = (this.window.innerWidth > 0) ? this.window.innerWidth : this.screen.width;
        if (width < 768) {
            $('div.navbar-collapse').addClass('collapse');
            topOffset = 100; // 2-row-menu
        } else {
            $('div.navbar-collapse').removeClass('collapse');
        }

        height = ((this.window.innerHeight > 0) ? this.window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1) height = 1;
        if (height > topOffset) {
            $("#page-wrapper").css("min-height", (height) + "px");
        }
    });

    var url = window.location;
    var element = $('ul.nav a').filter(function () {
        return this.href == url || url.href.indexOf(this.href) == 0;
    }).addClass('active').parent().parent().addClass('in').parent();
    if (element.is('li')) {
        element.addClass('active');
    }

    var userTable = $("#userTable").DataTable({
        serverSide: true, //服务端处理
        processing: false, //table在处理状态时显示友好信息
        //deferRender: true, //延迟渲染，可以提高初始化的速度
        stateSave: true, //保存状态
        //searching: false,//关闭搜索
        ordering: false,//关闭排序
        //paginationType: "full_numbers",//分页效果
        //lengthChange: false, //不可改变每页显示的大小
        displayLength: 10,//每页显示10条
        language: {
            /*汉化*/
            lengthMenu: "每页显示 _MENU_ 条记录",
            zeroRecords: "没有检索到数据",
            info: "当前记录从第 _START_ 条 到 _END_ 条数据；总共有 _TOTAL_ 条记录",
            infoEmpty: "没有数据",
            infoFiltered: "(从 _MAX_ 条记录过滤)",
            processing: "正在加载...",
            search: "搜索",
            sSearchPlaceholder: "手机号或者用户名",
            paginate: {
                first: "首页",
                last: "尾页",
                previous: "上一页",
                next: "下一页"
            }
        },
        ajax: {
            url: baseUrl + "/user/getTableData",
            //dataSrc: "data", //定义数据源属性
            cache: false,
            type: "get",
            dataType: "json",
            data: function (d) {
                return "pData=" + JSON.stringify(d);
            },
            error: function (data) {
                alert(data.error)
            }
        }
        ,
        columns: [
            {"data": "id"},
            {"data": "userName"},
            {"data": "mobile"},
            {
                "data": "gender",
                render: function (data, type, row) { //处理性别
                    if (type == 'display' || type == 'filter') {
                        if (data == 1) {
                            return '男'
                        } else if (data == 0) {
                            return '女'
                        } else {
                            return data;
                        }
                    }
                    return data;
                }
            },
            {
                "data": "createTime",
                render: function (data, type, row) { //处理日期格式
                    if (type == 'display' || type == 'filter') {
                        var d = new Date(data);
                        return d.getFullYear() + '-' + d.getMonth() + '-' + d.getDay() + " "
                            + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
                    }
                    return data;
                }
            }
        ]
    });
});
