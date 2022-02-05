## Part 1 - Better Names

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

## Part 1b - Better names, again.

Applied recommendation:
- Unique "shapes" of names

```javascript
var workspaceOverlay = document.createElement("div");

//A button to change workspaceOverlay's visibility
var toggleWorkspaceVisibilityBtn = document.createElement("button");

//A button to remove all canvas elements from workspaceOverlay
//Previously removeWorkspaceCanvasesBtn
var removeWorkCanvasesBtn = document.createElement("button");
```

Naming the last variable to removeWorkCanvasesBtn as demonstrated above would be sufficient, as it eliminates the reason that the two variables with different targets seemed similar (which could mistakenly imply similar functionality e.g. do something directly to workspaceOverlay itself) initially. The reason being the word "Workspace" and "Btn" in their names.