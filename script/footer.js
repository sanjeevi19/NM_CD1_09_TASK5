function showMessageFooter() {
    const clickButtonFooter = document.getElementById("clickButtonFooter");
    const messageBoxFooter = document.getElementById("messageBoxFooter");
    const hideInputFooter = document.getElementById("hideInputFooter");

    // Hide the button
    clickButtonFooter.style.display = "none";
    hideInputFooter.style.display = "none";

    // Display the message box
    messageBoxFooter.style.display = "block";
}