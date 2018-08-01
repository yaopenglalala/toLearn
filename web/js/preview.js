function preview(sourceId, targetId) {
    var url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    var imgPre = document.getElementById(targetId);
    imgPre.src = url;
}
