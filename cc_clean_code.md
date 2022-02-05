## Part 1 - Intention-revealing names & pronouncable names

Applied recommendations include:
- Intention-revealing names
- Pronounceable names
- Use searchable names
- Make meaningful distinctions

```javascript
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
    var workCanvases = workspaceOverlay.getElementsByClassName("canvas");
    while (workCanvases.length > 0) {
        workspaceOverlay.removeChild(workCanvases[0]);
    }
})

var initialCanvas = document.createElement("canvas");
initialCanvas.classList.add("canvas","overlay-content");
workspaceOverlay.appendChild(initialCanvas);
```