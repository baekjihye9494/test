/**
 * 
 */


$(document).ready(function () {
    $("#btnAdd").click(function () {
        let title = $("#title").val();
        let content = $("#content").val();
        let stName = $("#stName").val();
        let cpName = $("#cpName").val();
        let writer = $("#memberName").val();
        if (!title) {
            alert("제목을 입력하세요");
            document.form.title.focus();
            return;
        }
        if (!content) {
            alert("내용을 입력하세요");
            document.form.content.focus();
            return;
        }
        if (!stName) {
            alert("현장을 선택해주세요");
            document.form.stName.focus();
            return;
        }
        if (!cpName) {
            alert("내용을 입력하세요");
            document.form.cpName.focus();
            return;
        }
        document.form.submit();
    });
});