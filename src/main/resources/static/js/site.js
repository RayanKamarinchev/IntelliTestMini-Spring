function textAreaAdjust(element) {
    element.style.height = "1px";
    element.style.height = element.scrollHeight + "px";
}

[...document.querySelectorAll("div > div.questTextBox.questAnswer > div > textarea")].forEach(e => {
    textAreaAdjust(e)
});
[...document.querySelectorAll("#questions > div > div.customRow > div > textarea")].forEach(e => {
    textAreaAdjust(e)
});

[...document.querySelectorAll("input[type=hidden]")].forEach(e => {
    document.body.append(e);
    e.remove();
})