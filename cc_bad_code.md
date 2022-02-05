## Part 1 - Some problems with names

### Non-intention-revealing

These variables' intended purposes can be guessed by looking at their overall codes. However those could be more easily be represented by more carefully chosen names as demonstrated in cc_clean_code.md

### Unpronounciable names

In addition to that, it is better for the names to be pronouncable, unlike "cbtn" and "rmbtn" which not only requires more mental effort to remember and conceptualize compared to natural-language whole words, but may also cause difficulty in communication as they can be pronounced in different ways such as "see bee tee en", "cbutton", "kubten", "rumbten, "ar em bee tee en", etc.

### Non-search-friendly names

The variable "div", especially because it is in the global scope i.e. expected to be found in in many parts of the code, could turn out to be difficult to search due to it being an exact HTML tag as well. If one needs to search for where it is referenced, one may find themselves being directed to many code sections unrelated to this actual "div" variable.

There is a similar issue with the variable "canvas" (local variable in rmbtn's onclick function), though to a lesser extent, since it is in a smaller scope. Not much need for searching as far as it is concerned.

### Lack of meaningful distinctions

"var canvas1"...

It can be implied that more than one "canvas" elements exists by looking at rmbtn's onclick function and how the global variable "canvas1" is named.

It is important then to provide more information in the name so it can be more easily identified in other portions of the overall code.

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
    var canvas = div.getElementsByClassName("canvas");
    while (canvas.length > 0) {
        div.removeChild(canvas[0]);
    }
})

var canvas1 = document.createElement("canvas");
canvas1.classList.add("canvas","overlay-content");
div.appendChild(canvas1);
```