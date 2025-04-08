SELECT p.nom, SUM(d.montant) as Depense, (p.montant -  SUM(d.montant)) as Reste
FROM Depense d
JOIN Prevision p
ON d.idPrevision = p.idPrevision
WHERE d.dateDepense >= ? AND d.dateDepense <= ?
GROUP BY p.nom
ORDER BY p.idPrevision ASC;

SELECT nom
FROM Prevision 
WHERE idPrevision = 1;