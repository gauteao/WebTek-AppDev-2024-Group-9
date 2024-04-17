/*
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

                // Get the hotel container
                var hotelContainer = document.querySelector('.hotel-container');

                // Clear previous results
                hotelContainer.innerHTML = '';

                // Display hotels
                hotels.forEach(function (hotel, index) {
                    // Create hotel element
                    var hotelElement = document.createElement('div');
                    hotelElement.classList.add('hotel');

                    // Create image element
                    var img = document.createElement('img');
                    img.src = `images/hotel${index + 1}.avif`; // Adjust the image source as needed
                    img.alt = hotel.name;
                    img.classList.add('hotel-image');

                    // Create heading element
                    var h3 = document.createElement('h3');
                    h3.textContent = hotel.name;

                    // Create location paragraph element
                    var locationP = document.createElement('p');
                    locationP.textContent = `${hotel.city}, ${hotel.country}`;

                    // Create price paragraph element
                    var priceP = document.createElement('p');
                    priceP.textContent = `Starting at $${hotel.price} per night`;

                    // Append elements to hotel element
                    hotelElement.appendChild(img);
                    hotelElement.appendChild(h3);
                    hotelElement.appendChild(locationP);
                    hotelElement.appendChild(priceP);

                    // Append hotel element to hotel container
                    hotelContainer.appendChild(hotelElement);
                });
            } else {
                console.error('Request failed. Status: ' + xhr.status);
            }
        };

        xhr.send();
    });
};*/
