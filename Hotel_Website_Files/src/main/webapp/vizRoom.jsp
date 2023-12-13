<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room Occupancy Visualization</title>

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
                    <h2 align="center">Room Occupancy Visualization</h2>

                    <canvas id="roomOccupancyChart" width="400" height="150"></canvas>
                    <div align="center">
								<a href="welcome.jsp" class="btn btn-success"style="background-color:#ff6600; border:none">Go Back</a>
                       
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
        // Function to fetch room occupancy data from the servlet
        function fetchRoomOccupancyData() {
            fetch('VizRoomServlet?startDate=<%= request.getParameter("startDate") %>&endDate=<%= request.getParameter("endDate") %>')
                .then(response => response.json())
                .then(data => {
                    renderRoomOccupancyChart(data);
                })
                .catch(error => console.error('Error fetching data:', error));
        }

        // Function to render the room occupancy chart
        function renderRoomOccupancyChart(roomOccupancyData) {
            var roomTypes = roomOccupancyData.map(data => data.roomType);
            var roomOccupancyValues = roomOccupancyData.map(data => data.occupancy);
			
            Chart.defaults.color = 'white';
            const ctx = document.getElementById('roomOccupancyChart').getContext('2d');
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: roomTypes,
                    datasets: [{
                        label: 'Occupancy',
                        data: roomOccupancyValues,
                        backgroundColor: 'rgba(255, 102, 0, 0.5)',
                        borderColor: 'rgba(255, 102, 0, 1)',
                        borderWidth: 1,
                    }]
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

        // Call the fetchRoomOccupancyData function to load data
        fetchRoomOccupancyData();
    </script>
</body>
</html>
