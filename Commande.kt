import android.view.ContextMenu
import android.view.WindowInsetsAnimation
import androidx.core.location.LocationRequestCompat


class Commande(
    var numero : Int,
    var date : String,
    var client : Client,
    var produit : Produit,
    var quantite: Int,


)

{
    var statut: StatutDeCommande = StatutDeCommande.CREATED
        private set


    fun mentantTotal(): Double{
        return produit.calculerTTC() * quantite

    }

    fun payer(): Boolean {
        if (this.statut == StatutDeCommande.CREATED) {
            if (produit.retirerStock(quantite)) {
                statut = StatutDeCommande.PAID
                return true
            }

        }
        return false
    }

    fun expedier(): Boolean{
        if(statut == StatutDeCommande.PAID){
            statut = StatutDeCommande.SHIPPED
            return true
        }
        return false
    }


    fun comendAnuler(): Boolean{
        if (statut == StatutDeCommande.SHIPPED){
            return false
        }

        if(statut == StatutDeCommande.PAID){
            produit.ajouterStock(quantite)        }

        statut = StatutDeCommande.CANCELLED
        return true
    }












}
