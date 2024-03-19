console.log("script.js loaded");

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

document.getElementById('booking-form').addEventListener('submit', function(event) {
    // Prevent the form from submitting normally
    event.preventDefault();

    // Get the form inputs
    var cityPreference = document.getElementsByName('city_preference')[0].value;
    var checkinDate = document.getElementsByName('checkin')[0].value;
    var checkoutDate = document.getElementsByName('checkout')[0].value;
    var roomPreference = document.getElementsByName('room_preference')[0].value;
    var totalGuests = document.getElementsByName('total_guests')[0].value;

    // Encode form data as URL parameters
    var params = new URLSearchParams();
    params.append('city_preference', cityPreference);
    params.append('checkin', checkinDate);
    params.append('checkout', checkoutDate);
    params.append('room_preference', roomPreference);
    params.append('total_guests', totalGuests);

    // Redirect to hotel-search.html with URL parameters
    window.location.href = "hotel-search.html?" + params.toString();
});