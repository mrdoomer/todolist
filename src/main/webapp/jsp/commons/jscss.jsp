body {
  margin: 0;
  font-family: Arial, sans-serif;
}

header {
  background-color: #333;
  color: #fff;
  padding: 20px;
  text-align: center;
}

.sidebar {
  background-color: #f4f4f4;
  width: 200px;
  height: 100vh;
  position: fixed;
  top: 0;
  left: 0;
}

.tabs {
  padding-top: 20px;
}

.tab {
  display: block;
  width: 100%;
  padding: 10px;
  border: none;
  background-color: transparent;
  cursor: pointer;
}

.tab:hover {
  background-color: #ddd;
}

main {
  margin-left: 200px; /* Adjust based on sidebar width */
  padding: 20px;
}

