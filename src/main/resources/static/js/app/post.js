/**
 * post.hbs
 */

var post = {
    init : function(){
        var _this = this;
        console.log(this);
        $('#btn-list').on('click', function(){
            _this.list();
        });
        $('#btn-modify').on('click', function(){
            _this.modify();
        });
        $('#btn-delete').on('click', function(){
            _this.delete();
        });
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
                type: 'PUT',
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
        if(confirm('게시글을 삭제하시겠습니까?'))
        {
            var data = $('#delete-id').val();
            $.ajax({
                type: 'DELETE',
                url: '/posts/delete',
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                data: data
            }).done(function(id){
                alert(id + '번 글이 삭제되었습니다.');
                location.href = '/';
            }).fail(function(err){
                alert(JSON.stringify(err));
                console.log(err);
            });
        }
    }
}

post.init();

