var dropdownContent = document.querySelector('.dropdown-content');
var dropbtn = document.querySelector('.dropbtn');
var timeout;

dropbtn.addEventListener('mouseover', function(event) {
    clearTimeout(timeout); // Clear the timeout if it's set
    dropdownContent.style.display = 'block';
});

dropbtn.addEventListener('mouseout', function(event) {
    // Set a timeout to hide the dropdown after 2 seconds
    timeout = setTimeout(function() {
        dropdownContent.style.display = 'none';
    }, 1000);
});

dropdownContent.addEventListener('mouseover', function(event) {
    clearTimeout(timeout); // Clear the timeout if it's set
    dropdownContent.style.display = 'block';
});

dropdownContent.addEventListener('mouseout', function(event) {
    // Set a timeout to hide the dropdown after 2 seconds
    timeout = setTimeout(function() {
        dropdownContent.style.display = 'none';
    }, 1000);
});

console.log("script.js loaded");