## Part 1 - Better Names

Applied recommendations include:
- Intention-revealing names
- Pronounceable names
- Use searchable names
- Elimination of disinformation caused by misinforming names
- Introduction of meaningful distinctions

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

## Part 1b - Better names, again.

Applied recommendation:
- Unique "shapes" of names
- Use verbs only in method names, and use names for variables instead

```javascript
var workspaceOverlay = document.createElement("div");

//A button to change workspaceOverlay's visibility
var workspaceVisibilityToggleBtn = document.createElement("button");

//A button to remove all canvas elements from workspaceOverlay
//Previously removeWorkspaceCanvasesBtn
var workspaceCanvasesRemovalBtn = document.createElement("button");
```