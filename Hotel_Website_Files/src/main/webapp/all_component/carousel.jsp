<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        #imageCarousel {
            width: 100%; /* Set the width to your desired fixed width */
            height: 400px; /* Set the height to your desired fixed height */
            margin: 0 auto; /* Center the carousel horizontally */
            overflow: hidden; /* Hide overflowing content if images are larger */
        }

        .carousel-item img {
            width: 900%;
            height: 300px;
            object-fit: cover;
        }
    </style>
</head>
<body>
    <div id="imageCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="image/hotel_site7.jpg" alt="Hotel Image 1">
            </div>
            <div class="carousel-item">
                <img src="image/hotel_site2.jpg" alt="Hotel Image 2">
            </div>
            <div class="carousel-item">
                <img src="image/hotel_site5.jpg" alt="Hotel Image 3">
            </div>
            <div class="carousel-item">
                <img src="image/hotel_site6.jpg" alt="Hotel Image 4">
            </div>
        </div>
        <a class="carousel-control-prev" href="#imageCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" ariahidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#imageCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</body>
</html>
