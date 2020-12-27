var menus = [
    {
        name: '饮食管理',
        menus: [
            {
                name: '饮食管理',
                url: 'foods/listPage'
            }
        ]
    },
    {
        name: '运动管理',
        menus: [
            {
                name: '运动管理',
                url: 'sport/listPage'
            }
        ]
    },
    {
        name: '推荐管理',
        menus: [
            {
                name: '推荐管理',
                url: 'swiper/listPage'
            },
            {
                name: '推荐饮食管理',
                url: 'swiperFoods/listPage'
            }
        ]
    },
    {
        name: '用户管理',
        menus: [
            {
                name: '用户管理',
                url: 'user/listPage'
            }
        ]
    },
]
//JavaScript代码区域
layui.use('element', function () {
    var element = layui.element;
    initMenu();
    element.render('nav_layui');
});

function initMenu() {
    $('#nav_layui').empty();
    var leftMenu = '';
    $.each(menus, function (index, parent) {
        leftMenu += '<li class="layui-nav-item">';
        leftMenu += '<a class="" href="javascript:;">' + parent.name + '</a>';
        leftMenu += '<dl class="layui-nav-child">';
        $.each(parent.menus, function (childIndex, child) {
            var childEl = '<dd>' +
                '<a href="' + child.url + '" target="myframe">' + child.name + '</a>' +
                '</dd>';
            leftMenu += childEl;
        });
        leftMenu += '</dl>';
        leftMenu += '</li>';
    });
    $('#nav_layui').html(leftMenu);
}

