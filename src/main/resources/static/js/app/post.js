/**
 * post.hbs
 */

var post = {
    init : function(){
        var _this = this;
        console.log(this);

    },

    list : function() {
        window.location.href = '/';
    },

    modify : function(){
        if(confirm('게시글을 수정하시겠습니까?'))
        {
            var data = {
                id: $('#id').val(),
                title: $('#title').val(),
                content: $('#content').val()
            };

            $.ajax({
                type: 'POST',
                url: '/posts/modify',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function(){
                alert('수정되었습니다.');
                location.reload();
            }).fail(function(err){
                alert(JSON.stringify(err));
                console.log(err);
            });
        }
    },

    delete : function(){

    }
}

post.init();

