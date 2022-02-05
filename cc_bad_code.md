## Part 1 - Some problems with names

### Source code

Below is a part of a larger code base I have written. I extracted just the minimum amount of lines from it and tweak it a bit to cover several recommendations of the textbook.

```javascript
var div = document.createElement("div");
div.className = "overlay";

var cbtn = document.createElement("button");
cbtn.className = "togglebtn";
cbtn.innerHTML = "&#8230";
cbtn.addEventListener("click", function() {
    div.style.display = div.style.display == "none" ? "block" : "none";
})

var rmbtn = document.createElement("button");
rmbtn.className = "clearbtn";
rmbtn.innerHTML = "&times";
rmbtn.addEventListener("click", function() {
    div.style.display = "none";
    var canvasArray = div.getElementsByClassName("canvas");
    while (canvasArray.length > 0) {
        div.removeChild(canvasArray[0]);
    }
})

var canvas1 = document.createElement("canvas");
canvas1.classList.add("canvas","overlay-content");
div.appendChild(canvas1);
```

### Non-intention-revealing

These variables' intended purposes can be guessed by looking at their overall codes. However those could be more easily be represented by more carefully chosen names as demonstrated in cc_clean_code.md

### Unpronounceable names

In addition to that, it is better for the names to be pronounceable, unlike "cbtn" and "rmbtn" which not only requires more mental effort to remember and conceptualize compared to natural-language whole words, but may also cause difficulty in communication as they can be pronounced in different ways such as "see bee tee en", "cbutton", "kubten", "rumbten, "ar em bee tee en", etc.

### Non-search-friendly names

The variable "div", especially because it is in the global scope i.e. expected to be found in in many parts of the code, could turn out to be difficult to search due to it being an exact HTML tag as well. If one needs to search for where it is referenced, one may find themselves being directed to many code sections unrelated to this actual "div" variable.

### Disinformation

"var canvasArray" actually references an HTMLCollection object, not an Array. While in some ways it can be treated as an Array i.e. has property "length" to be used to iterate thru elements in a for-loop by index, it has other possible functionalities not available to Arrays such as accessing elements by their HTML attribute "id".

Naming the local variable just "canvases" in this case would even be better as that would be the minimum to do. Causing disinformation is worse than meeting minimum requirements with no added information.

### Lack of meaningful distinctions

"var canvas1"...

It can be implied that more than one "canvas" elements exists by looking at rmbtn's onclick function and how the global variable "canvas1" is named.

It is important then to provide more information in the name e.g. naming it mainCanvas or initialCanvas, so it can be more easily identified in other portions of the overall code.

#### Solution

Fixed code segment is in the other file, cc_clean_code.md

<br>

## Part 1b - Another problem with names

### Source code

Actually this is part of the solution to the above code, only including the declaration/initialization of variables. The rest of it can be seen in the other file.

I added explanations for a bit of context

```javascript
//A div element which canvas HTML elements will be appended to
var workspaceOverlay = document.createElement("div");

//A button toggle whether workspaceOverlay is visible or hidden
//Target: workspaceOverlay
var toggleWorkspaceVisibilityBtn = document.createElement("button");

//A button to remove all canvas elements from workspaceOverlay
//Target: workspaceOverlay's children
var removeWorkspaceCanvasesBtn = document.createElement("button");
```

### Similar shaped names but way different meanings

The names do represent what they are intended for. However, it requires careful reading. For a first time reader, one may get the wrong impression that removeWorkspaceCanvasesBtn has workspaceOverlay as its primary target of action (remove), especially since toggleWorkspaceVisibilityBtn, which has a similar shape, comes before it. In actuality, removeWorkspaceCanvasesBtn acts on the a specific selection of workspaceOverlay's children.

#### Solution

Solution can be found in the other file, cc_clean_code.md