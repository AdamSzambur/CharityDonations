$(function () {
    var context = window.location.pathname;
    console.log(context);
    var messageBox = $('#messageBox');
    $('.message-btn').click(function () {
        console.log($(this).data('id'));
        messageBox.find('#elementId').attr('value',$(this).data('id'));
        messageBox.toggleClass('invisible');
    });
});