fun commandesDuClient(commandes: List<Commande>, client: String): List<Commande> =
    commandes.filter { it.client.nom == client }

fun totalPayees(commandes: List<Commande>): Double =
    commandes.filter { it.statut == StatutDeCommande.PAID }.sumOf { it.mentantTotal() }

fun totalAnnulees(commandes: List<Commande>): Double =
    commandes.filter { it.statut == StatutDeCommande.CANCELLED }.sumOf { it.mentantTotal() }