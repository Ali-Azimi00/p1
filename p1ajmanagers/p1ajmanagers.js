document.addEventListener("DOMContentLoaded", function () {
  var table = document.querySelector("table");
  var tbody = table.querySelector("tbody");

  // Loop through each row in the table body
  var rows = tbody.querySelectorAll("tr");
  rows.forEach(function (row) {
    var cells = row.querySelectorAll("td");

    for (var i = 7; i < cells.length; i++) {
      var cell = cells[i];

      // Create radio inputs
      var radioName = "radio-" + row.rowIndex; // Generate unique name for each row
      var radio = document.createElement("input");
      radio.type = "radio";
      radio.name = radioName;

      // Append radio input to the cell
      cell.appendChild(radio);
    }
  });
  
  function myApproved() {
    

  }
});