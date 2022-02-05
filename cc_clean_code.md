## Part 1 - Intention-revealing names & pronouncable names

```
var workspaceOverlay = document.createElement("div");
workspaceOverlay.className = "overlay";

var toggleWorkspaceVisibilityBtn = document.createElement("button");
toggleWorkspaceVisibilityBtn.className = "togglebtn";
toggleWorkspaceVisibilityBtn.innerHTML = "&#8230";
toggleWorkspaceVisibilityBtn.addEventListener("click", function() {
    workspaceOverlay.style.display = workspaceOverlay.style.display == "none" ? "block" : "none";
})

var removeWorkspaceCanvasesBtn = document.createElement("button");
removeWorkspaceCanvasesBtn.className = "clearbtn";
removeWorkspaceCanvasesBtn.innerHTML = "&times";
removeWorkspaceCanvasesBtn.addEventListener("click", function() {
    workspaceOverlay.style.display = "none";
    var possibleCanvases = workspaceOverlay.getElementsByClassName("canvas");
    while (possibleCanvases.length > 0) {
        workspaceOverlay.removeChild(possibleCanvases[0]);
    }
})

var startingCanvas = document.createElement("canvas");
startingCanvas.classList.add("canvas","overlay-content");
workspaceOverlay.appendChild(startingCanvas);
```