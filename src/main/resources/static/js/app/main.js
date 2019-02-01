/**
 * main.hbs
 * @type {{init: main.init, saveMembers: main.saveMembers, savePosts: main.savePosts}}
 */

var main = {
    init: function () {
        var _this = this;
        $('#btn-saveMembers').on('click', function () {
            _this.saveMembers();
        });

        $('#btn-savePosts').on('click', function () {
            _this.savePosts();
        });
    },

    saveMembers: function () {
        var data = {
            name: $('#name').val(),
            email: $('#email').val(),
            password: $('#password').val(),
            phone: $('#phone').val()
        };

        $.ajax({
            type: 'POST',
            url: '/signMember',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원정보가 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    },

    savePosts: function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/savePost',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }
};

main.init();