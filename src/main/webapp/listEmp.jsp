<%@ page import = "form.*, DAOobj.*, objects.*, java.util.*" %> <% List<Etat>
  deps = (List<Etat
    >) request.getAttribute("deps"); %>
    <!DOCTYPE html>
    <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>listEmpt</title>
        <style>
          :root {
            --primary-color: #3498db;
            --secondary-color: #2980b9;
            --accent-color: #e74c3c;
            --light-color: #ecf0f1;
            --dark-color: #2c3e50;
            --success-color: #2ecc71;
            --warning-color: #f39c12;
            --border-radius: 8px;
            --box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            --transition: all 0.3s ease;
          }

          * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
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
            margin: 25px 0;
            text-align: center;
            font-size: 2rem;
          }

          table {
            width: 100%;
            border-collapse: collapse;
            margin: 25px 0;
            box-shadow: var(--box-shadow);
            background-color: white;
            border-radius: var(--border-radius);
            overflow: hidden;
          }

          th,
          td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
          }

          th {
            background-color: var(--primary-color);
            color: white;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
          }

          tr:nth-child(even) {
            background-color: #f8f9fa;
          }

          tr:hover {
            background-color: #f1f1f1;
          }

          a {
            color: var(--warning-color);
            text-decoration: none;
            font-weight: 600;
            padding: 5px 10px;
            border-radius: var(--border-radius);
            transition: var(--transition);
          }

          a:hover {
            background-color: rgba(243, 156, 18, 0.1);
            text-decoration: underline;
          }

          /* Bouton pour retourner à l'ajout */
          .back-link {
            display: inline-block;
            background-color: var(--success-color);
            color: white;
            text-decoration: none;
            padding: 12px 25px;
            border-radius: var(--border-radius);
            margin-top: 20px;
            font-weight: 600;
            transition: var(--transition);
          }

          .back-link:hover {
            background-color: #27ae60;
            transform: translateY(-2px);
            text-decoration: none;
          }

          /* Responsive design */
          @media (max-width: 768px) {
            table {
              display: block;
              overflow-x: auto;
            }

            th,
            td {
              padding: 8px 10px;
            }
          }
        </style>
      </head>
      <body>
        <h2>Etat</h2>
        <table>
          <thead>
            <tr>
              <th>Libelle</th>
              <th>Depense</th>
              <th>Reste</th>
            </tr>
          </thead>
          <tbody>
            <% for (Etat e : deps) { %>
            <tr>
              <td><%= e.getNom() %></td>
              <td><%= e.getMontant() %></td>
              <td><%= e.getReste() %></td>
            </tr>
            <% } %>
          </tbody>
        </table>
        <a href="<%= request.getContextPath() %>/accueil" class="back-link"
          >Retour</a
        >
      </body>
    </html>
  </Etat>
</Etat>
