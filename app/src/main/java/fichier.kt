
import java.io.File

fun ecrirehistorique(client: Client, commande: List<Commande>) {
    val historique = commande
        .filter { it.client.code == client.code }
        .joinToString("\n\n") { commande ->
                    "Commende Numero : ${commande.numero}\n" +
                    "Date : ${commande.date}\n" +
                    "Produit : ${commande.produit.nom}\n" +
                    "Quantite : ${commande.quantite}\n" +
                    "Montant : ${commande.mentantTotal()}\n" +
                    "Statut : ${commande.statut}"
        }
    val fichier = File("Client${client.code}.txt")
    fichier.writeText(historique)

    println("Fichier créé ici : ${fichier.absoluteFile}")
}
