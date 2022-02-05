
## Part 2a - Some problems with functions

### Source code

```javascript
function newCalendar() {
    canvas = document.createElement("canvas");
    canvas.classList.add("canvas","overlay-content");
    workspaceOverlay.appendChild(canvas);

    canvas.width = Math.min(
        maxCalendarWidthPixel,
        window.innerWidth * maxCalendarToWindowWidthRatio);

    canvas.height = Math.min(
        canvas.width * 0.8
        * (1 + 1/WEEKS_PER_MONTH * monthTextOffset)
        * (1 + 1/WEEKS_PER_MONTH * weekdayTextFillOffset)
        ,
        window.innerHeight * 0.92
    );
    
    var numberOfFillColumnSegments = DAYS_PER_WEEK;
    var numberOfGapColumnSebments = (DAYS_PER_WEEK + canvasBorderOffset);
    var numberOfFillRowSegments = (
        WEEKS_PER_MONTH
        + monthTextOffset
        + weekdayTextFillOffset
        );
    var numberOfGapRowSegments = (
        WEEKS_PER_MONTH
        + canvasBorderOffset 
        + monthTextOffset 
        + weekdayTextGapOffset
        );
    fillWidth = 1 / numberOfFillColumnSegments * (horizontalFillToGapRatio) * canvas.width;
    gapWidth = 1 / numberOfGapColumnSebments * (1 - horizontalFillToGapRatio) * canvas.width;
    fillHeight = 1 / numberOfFillRowSegments * (verticalFillToGapRatio) * canvas.height;
    gapHeight = 1 / numberOfGapRowSegments * (1- verticalFillToGapRatio) * canvas.height;

    if (gapWidth > gapHeight) {
        gapWidth = gapHeight;
        horizontalFillToGapRatio = 1 - (gapWidth * (DAYS_PER_WEEK + canvasBorderOffset) / canvas.width);
        fillWidth = 1 / DAYS_PER_WEEK * (horizontalFillToGapRatio) * canvas.width;
    }
    else {
        gapHeight = gapWidth;
        verticalFillToGapRatio = 1 - (gapHeight * (WEEKS_PER_MONTH + canvasBorderOffset + monthTextOffset + weekdayTextGapOffset) / canvas.height);
        fillHeight = 1 / (WEEKS_PER_MONTH + monthTextOffset + weekdayTextGapOffset) * (verticalFillToGapRatio) * canvas.height;
    }    

    pencilBorderOffset = bordersImplemented ? gapWidth : 0;
    pencilX = 0 + pencilBorderOffset;
    pencilY = 0 + pencilBorderOffset

    ctx = canvas.getContext("2d");
    noShadowColor = ctx.shadowColor;
    ctx.shadowBlur = gapWidth/2;
    ctx.shadowOffsetX = gapWidth/2;
    ctx.shadowOffsetY = gapHeight/2;
    ctx.textBaseline = 'middle';
    ctx.textAlign = 'center';
}
```

### Problems.
- Method names should be verbs.
createNewCalendar() would be a more appropriate label in this case.
- Too many levels of abstractions in just one function.
Functions should contain one level abstraction of code. In this case, createNewCalendar() should only contain functions that tell the reader immediately how the new calendar is created, which is to perpareNewCanvas() and drawCalendar()
- There are "side effects" to running this code.
In this case, the variables fillWidth, fillHeight, gapWidth, gapHeight, pencilBorderOffset, pencilX, pencilY, monthBoxWidth, and ctx which are all global variables (not declared inside the function), are changed. This would if the, right circumstances meet, cause unexpected behaviour as changes may not be expected.
