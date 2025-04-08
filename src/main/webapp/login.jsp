<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        :root {
          --primary-color: #3498db;
          --secondary-color: #2980b9;
          --accent-color: #e74c3c;
          --light-color: #ecf0f1;
          --dark-color: #2c3e50;
          --success-color: #2ecc71;
          --border-radius: 8px;
          --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
          --transition: all 0.3s ease;
        }
  
        * {
          margin: 0;
          padding: 0;
          box-sizing: border-box;
          font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
  
        body {
          background-color: #f5f7fa;
          color: var(--dark-color);
          line-height: 1.6;
          padding: 20px;
          max-width: 1200px;
          margin: 0 auto;
        }
  
        h2 {
          color: var(--primary-color);
          margin: 25px 0 15px;
          padding-bottom: 10px;
          border-bottom: 2px solid var(--light-color);
        }
  
        form {
          background: white;
          padding: 25px;
          border-radius: var(--border-radius);
          box-shadow: var(--box-shadow);
          margin-bottom: 30px;
          transition: var(--transition);
        }
  
        form:hover {
          box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }
  
        label {
          display: block;
          margin-bottom: 8px;
          font-weight: 600;
          color: var(--dark-color);
        }
  
        input[type="text"],
        select {
          width: 100%;
          padding: 12px;
          margin-bottom: 20px;
          border: 1px solid #ddd;
          border-radius: var(--border-radius);
          font-size: 16px;
          transition: var(--transition);
        }
  
        input[type="text"]:focus,
        select:focus {
          outline: none;
          border-color: var(--primary-color);
          box-shadow: 0 0 0 3px rgba(52, 152, 219, 0.2);
        }
  
        input[type="text"]::placeholder {
          color: #95a5a6;
        }
  
        button[type="submit"] {
          background-color: var(--primary-color);
          color: white;
          border: none;
          padding: 12px 25px;
          border-radius: var(--border-radius);
          cursor: pointer;
          font-size: 16px;
          font-weight: 600;
          transition: var(--transition);
        }
  
        button[type="submit"]:hover {
          background-color: var(--secondary-color);
          transform: translateY(-2px);
        }
  
        a {
          display: inline-block;
          background-color: var(--success-color);
          color: white;
          text-decoration: none;
          padding: 12px 25px;
          border-radius: var(--border-radius);
          margin-top: 10px;
          font-weight: 600;
          transition: var(--transition);
        }
  
        a:hover {
          background-color: #27ae60;
          transform: translateY(-2px);
        }
  
        input[type="hidden"] {
          display: none;
        }
  
        /* Responsive design */
        @media (min-width: 768px) {
          body {
            padding: 40px;
          }
  
          form {
            max-width: 600px;
            margin: 0 auto 40px;
          }
        }
      </style>
    <title>Login</title>
</head>
<body>
    <h2>Login page</h2>
    <form action="accueil" method="post">
      <label for="nom">email :</label>
      <input
        type="email"
        name="nom"
        id="nom"
        value="example@gmail.com"
        placeholder="Entrez votre nom"
        required
      />
      <label for="mdp">Password :</label>
      <input
        type="password"
        name="mdp"
        id="mdp"
        value="example123!"
        placeholder="Entrez votre montant"
        required
      />
      <button type="submit">Ok</button>
    </form>
</body>
</html>