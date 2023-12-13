<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Visualization</title>

    <!-- Include the Chart.js library -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>

    <%@include file="all_component/allCss.jsp"%>
    <link rel="stylesheet" href="all_component/style.css">
</head>
<body>
    <%@include file="all_component/NavBarAdmin.jsp"%>
    <p></p>

    <div class="container">
        <div class="card" style="background-color: rgba(0, 0, 0, 0.8); color: white;">
            <div class="row mt-2">
                <div class="col-md-12">
                    <h2 align="center">Daily Occupancy Visualization</h2>

                    <canvas id="bookingChart" width="400" height="150"></canvas>
                    <div align="center">
                        <a href="welcome.jsp" class="btn btn-success" style="background-color:#ff6600; border:none">Go Back</a>
                    </div>
                    <p></p>
                </div>
            </div>
        </div>
    </div>
<p><br><br><br><br></p>
    <div class="footer">
        <p>&copy; 2023 Our Hotel. All rights reserved. | <a href="#">Contact Us</a></p>
    </div>

    <script>
        // Function to fetch booking data from the servlet
        function fetchBookingData() {
            fetch('VizBookingServlet?startDate=<%= request.getParameter("startDate") %>&endDate=<%= request.getParameter("endDate") %>')
                .then(response => response.json())
                .then(data => {
                    renderBookingChart(data);
                })
                .catch(error => console.error('Error fetching data:', error));
        }

        // Function to render the booking chart
        function renderBookingChart(bookingData) {
            var dates = Array.from(new Set(bookingData.map(data => data.Date))); // Unique dates
            var roomTypes = Array.from(new Set(bookingData.map(data => data.RoomType))); // Unique room types

            Chart.defaults.color = 'white';
            const ctx = document.getElementById('bookingChart').getContext('2d');
            var datasets = [];

            // Create a dataset for each room type
            roomTypes.forEach(roomType => {
                var numRooms = dates.map(date =>
                    bookingData
                        .filter(data => data.RoomType === roomType && data.Date === date)
                        .reduce((sum, data) => sum + data.NumRooms, 0)
                );

                datasets.push({
                    label: roomType,
                    data: numRooms,
                    borderColor: getRandomColor(), // Generates a random color for each line
                    fill: false,
                });
            });

            new Chart(ctx, {
                type: 'line',
                data: {
                    labels: dates,
                    datasets: datasets,
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                            stepSize: 1,
                            ticks: {
                                font: {
                                    color: 'white' // Set the y-axis label font color to white
                                }
                            }
                        },
                        x: {
                            ticks: {
                                font: {
                                    color: 'white' // Set the x-axis label font color to white
                                }
                            }
                        }
                    },
                }
            });
        }

        // Call the fetchBookingData function to load data
        fetchBookingData();

        // Function to generate a random color
        function getRandomColor() {
            var letters = '0123456789ABCDEF';
            var color = '#';
            for (var i = 0; i < 6; i++) {
                color += letters[Math.floor(Math.random() * 16)];
            }
            return color;
        }
    </script>
</body>
</html>
