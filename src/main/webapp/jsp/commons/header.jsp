
<!-- Common Header (header.html) -->
<style>
    /* Style for the button */
    .button {
      display: inline-block;
      padding: 10px 20px;
      text-align: center;
      text-decoration: none;
      background-color: #808080;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    /* Style for the button on hover */
    .button:hover {
      background-color: #808080;
    }
  </style>
<header>

   <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" >Welcome, <b>${user.username}</b> </a>

  <a href="logout" class="button">Logout</a>
      </div>
      
       
    </nav>
</header>
