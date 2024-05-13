console.log("script.js loaded");

function commonOnLoad() {
        // Fetch navbar.html and insert its content into the navbar div
        fetch('./navbar.html')
            .then(response => response.text())
            .then(data => {
                const navbarDiv = document.getElementById('navbar');
                if (navbarDiv) {
                    navbarDiv.innerHTML = data;
                }
            });

 // Initialize the dropdown menu for login
    var dropdownContent = document.querySelector('.dropdown-content');
    var dropbtn = document.querySelector('.dropbtn');
    var timeout;

    dropbtn.addEventListener('mouseover', function (event) {
        clearTimeout(timeout); // Clear the timeout if it's set
        dropdownContent.style.display = 'block';
    });

    dropbtn.addEventListener('mouseout', function (event) {
        // Set a timeout to hide the dropdown after 2 seconds
        timeout = setTimeout(function () {
            dropdownContent.style.display = 'none';
        }, 1000);
    });

    dropdownContent.addEventListener('mouseover', function (event) {
        clearTimeout(timeout); // Clear the timeout if it's set
        positionDropdown();
        dropdownContent.style.display = 'block';
    });

    dropdownContent.addEventListener('mouseout', function (event) {
        // Set a timeout to hide the dropdown after 2 seconds
        timeout = setTimeout(function () {
            dropdownContent.style.display = 'none';
        }, 1000);
    });

    // Function to position dropdown dynamically
    function positionDropdown() {
        var rect = dropbtn.getBoundingClientRect();
        var dropdownHeight = dropdownContent.offsetHeight;
        var dropdownWidth = dropdownContent.offsetWidth;

        // Calculate top position
        var top = rect.top + dropbtn.offsetHeight;
        if (top + dropdownHeight > window.innerHeight) {
            top = rect.top - dropdownHeight;
        }

        // Calculate left position
        var left = rect.left;
        if (left + dropdownWidth > window.innerWidth) {
            left = window.innerWidth - dropdownWidth;
        }

        // Set position of the dropdown content
        dropdownContent.style.top = top + 'px';
        dropdownContent.style.left = left + 'px';
    }
}
