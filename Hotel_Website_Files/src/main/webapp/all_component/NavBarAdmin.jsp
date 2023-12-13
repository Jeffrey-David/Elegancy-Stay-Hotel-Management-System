<div class="container-fluid p-3" style="background-color: rgba(0, 0, 0, 0.7); padding: 10px;">
	<div class="row">
		<div class="col-md-3">
			 <a href="welcome.jsp">
			    <img src="image/logo.JPG" alt="Logo" style="width: 180px; height: 75px;">
			</a>

		</div>
		<div class="col-md-6">
			<form class="form-inline my-2 my-lg-0" action="SearchAdminServlet" method="post">
				<input class="form-control mr-sm-2" type="text" name="text"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-primary my-2 my-sm-0" style="background-color:#ff6600; border:none" type="submit"><i class="fa-solid fa-magnifying-glass"></i>Search</button>
			</form>
		</div>
		<div class="col-md-3">
			<a href="index.jsp" class="btn btn-success" style="background-color:#ff6600; border:none"><i class="fa-solid fa-right-to-bracket"></i>Logout</a>
		</div>
	</div>
</div>

<!-- <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">
                    <i class="fa-solid fa-house"></i> Home <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <i class="fa-solid fa-person-shelter"></i> Book Room
                </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <i class="fa-solid fa-square-phone"></i> Contact
                </a>
            </li>
        </ul>
    </div>
</nav> -->
