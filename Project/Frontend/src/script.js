console.log("script.js loaded");

window.onload = function () {
    // Fetch navbar.html and insert its content into the navbar div
    fetch('./navbar.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('navbar').innerHTML = data;
        });

    var picker = new Litepicker({
        element: document.getElementById('date-range'),
        singleMode: false,
        format: 'YYYY-MM-DD',
        delimiter: ' to ',
        autoApply: true,
        onSelect: function(date1, date2){
            var checkinDate = date1.format('YYYY-MM-DD');
            var checkoutDate = date2.format('YYYY-MM-DD');
            // Do something with the selected dates
        }
    });

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
document.getElementById('booking-form').addEventListener('submit', function (event) {
    // Prevent the form from submitting normally
    event.preventDefault();

    // Get the form inputs
    var cityPreference = document.getElementsByName('destination_preference')[0].value;
    var dateRange = document.getElementsByName('date_range')[0].value;
    var totalGuests = document.getElementsByName('total_guests')[0].value;

    // Split the date range into checkin and checkout dates
    var dates = dateRange.split(' to ');
    var checkinDate = dates[0];
    var checkoutDate = dates[1];

    // Make an AJAX request to the backend endpoint
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:8080/hotels/search?city=' + encodeURIComponent(cityPreference) +
        '&checkIn=' + encodeURIComponent(checkinDate) +
        '&checkOut=' + encodeURIComponent(checkoutDate) +
        '&guests=' + encodeURIComponent(totalGuests));

    xhr.onload = function () {
        if (xhr.status === 200) {
            // Parse the response JSON
            var hotels = JSON.parse(xhr.responseText);

            // Store the hotels data in sessionStorage to pass it to the next page
            sessionStorage.setItem('hotels', JSON.stringify(hotels));

            // Redirect the user to the results page
            window.location.href = 'results.html';
        } else {
            console.error('Request failed. Status: ' + xhr.status);
        }
    };

    xhr.send();
});