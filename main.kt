import Client

fun main() {
    var client1 = Client(1, "Abdelmoughit", "safi")
    var client2 = Client(2, "Salma", "Marakech")
    var client3 = Client(3, "Nabil", "Agadir")

    var produielc1 = ProduitElectonique("E1","PC", 5000.0, 20,12)
    var produielc2 = ProduitElectonique("E2", "TV", 4000.0,10,8)
    var produielc3 = ProduitElectonique("E3","phone",3000.0,50,5)

    var produialiment1 = ProduitAlimentaires("A1", "pain", 5.0, 200, "17-10-2026",)
    var produialiment2 = ProduitAlimentaires("A2", "spacity", 15.0, 100, "23-5-2027")
    var produialiment3 = ProduitAlimentaires("A3", "Sostomat", 20.0, 100, "28-7-2028")


    var cmd1 = Commande(1, "16-10-2026", client1,produielc1, 3)
    var cmd2 = Commande(2, "16-10-2026", client2,produielc2, 5)
    var cmd3 = Commande(3, "16-10-2026", client3,produielc3, 2)
    var cmd4 = Commande(4, "16-10-2026", client1,produialiment1, 3)
    var cmd5 = Commande(5, "16-10-2026", client2,produialiment2, 50)
    var cmd6 = Commande(6, "16-10-2026", client3,produialiment3, 80)

    println("COMEND 1")
    println("Client : ${cmd1.client.nom}")
    println("Stock avant paiement : ${produielc1.stock}")
    println("Paiement : ${cmd1.payer()}")
    println("Statut : ${cmd1.statut}")
    println("Stock après paiement : ${produielc1.stock}")


    println("COMMANDE 1")
    println("Expédition : ${cmd1.expedier()}")
    println("Statut : ${cmd1.statut}")
    println("Stock : ${produielc1.stock}")


    println("ANNULATION COMMANDE 1")
    println("Annulation : ${cmd1.comendAnuler()}")
    println("Statut : ${cmd1.statut}")
    println("Stock : ${produielc1.stock}")


    println("COMMANDE 2")
    println("Client : ${cmd2.client.nom}")
    println("Stock avant paiement : ${produielc2.stock}")
    println("Paiement : ${cmd2.payer()}")
    println("Statut : ${cmd2.statut}")
    println("Stock après paiement : ${produielc2.stock}")


    println("COMMANDE 3")
    println("Client : ${cmd3.client.nom}")
    println("Stock avant paiement : ${produielc3.stock}")
    println("Paiement : ${cmd3.payer()}")
    println("Stock après paiement : ${produielc3.stock}")
    println("Annulation : ${cmd3.comendAnuler()}")
    println("Statut : ${cmd3.statut}")
    println("Stock après annulation : ${produielc3.stock}")


    println("COMMANDE 4")
    println("Client : ${cmd4.client.nom}")
    println("Paiement : ${cmd4.payer()}")
    println("Statut : ${cmd4.statut}")
    println("Stock du pain : ${produialiment1.stock}")

    println("COMMANDE 5")
    println("Client : ${cmd5.client.nom}")
    println("Paiement : ${cmd5.payer()}")
    println("Statut : ${cmd5.statut}")
    println("Stock de Spacity : ${produialiment2.stock}")

    println("COMMANDE 6")
    println("Client : ${cmd6.client.nom}")
    println("Paiement : ${cmd6.payer()}")
    println("Statut : ${cmd6.statut}")
    println("Stock de Sostomat : ${produialiment3.stock}")


//boutique
    val laptop = ProduitElectonique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaires("A1", "Riz", 20.0, 100, "2027-01-01")
    val phone = ProduitElectonique("E2", "Phone", 2000.0, 20, 12)

    val boutique = Boutique()

    println(boutique.Ajouter(laptop))
    println(boutique.Ajouter(laptop))
    println(boutique.Ajouter(riz))
    println(boutique.Ajouter(phone))

    println(boutique.indiceProdui("A1"))
    println(boutique.indiceProdui("ZZ"))

    println(boutique.nombreProduitsElectroniques())

    println(boutique.supprimerCode("A1"))
    println(boutique.supprimerCode("A1"))

    println(boutique.supprimerProdui(laptop))
    println(boutique.nombreProduitsElectroniques())

    println(boutique.indiceProdui("E2"))




    //jeuDeDonnees
    //forEach
    val commandes = jeuDeDonnees() // // Initialisation des commandes une seule fois pour les réutiliser dans toute la fonction main()


    commandes.forEach { commande ->
        println("${commande.client.nom} : ${commande.mentantTotal()}")
    }

    //map
    var mantant = commandes.map { commande ->
        commande.mentantTotal()
    }
    println(mantant)


    //filter
    commandes.filter { it.mentantTotal() > 1000 }
        .forEach { println(it.numero) }



    //sortedBy & sortedByDescending
    println("Ordre croissant")
    commandes.sortedBy { it.mentantTotal() }
        .forEach { println(it.numero) }

    println("Ordre décroissant")
    commandes.sortedByDescending{ it.mentantTotal()}
        .forEach { println(it.numero) }



    //any & all
    val annulee = commandes.any {
        it.statut == StatutDeCommande.CANCELLED
    }
    println("Y a-t-il au moins une commande annulée ? $annulee")

    val toutesPayees = commandes.all {
        it.statut == StatutDeCommande.PAID
    }
    println("Toutes les commandes sont-elles payées ? $toutesPayees")



    //filter & sumOf
    val total = commandes
        .filter {
            it.client.ville == "Safi" &&
                    it.statut == StatutDeCommande.PAID
        }
        .sumOf { it.mentantTotal() }

    println("Total : $total DH")



    //maxByOrNull & filter
    val commandeMax = commandes
        .filter { it.statut == StatutDeCommande.PAID }
        .maxByOrNull { it.mentantTotal() }

    println(commandeMax?.client?.nom)



    //filter &  map & distinct
    val noms = commandes
            .filter { it.statut == StatutDeCommande.CANCELLED }
        .map { it.client.nom }
        .distinct()

    println(noms)



    //filter & sortedByDescending & take & map & forEach
    val resultat = commandes
        .filter { it.statut == StatutDeCommande.PAID }
        .sortedByDescending { it.mentantTotal() }
        .take(3)
        .map { "${it.client.nom} : ${it.mentantTotal()} DH" }

    resultat.forEach { println(it) }



    //filter & groupBy & mapValues & sumOf
    val chiffreAffaires = commandes
        .filter { it.statut == StatutDeCommande.PAID }
        .groupBy { it.client.ville }
        .mapValues { (_, commandesVille) ->
            commandesVille.sumOf { it.mentantTotal() }
        }

    println(chiffreAffaires)

    //fun part 3
    println(commandesDuClient(commandes, "Abdelmoughit"))
    println(totalPayees(commandes))
    println(totalAnnulees(commandes))



//Extensions etlambdas
//Extensions
    println("+212600000000".isValidPhoneNumber())
    println("0600000000".isValidPhoneNumber())
    println("+212 600 000 000".isValidPhoneNumber())
    println("+21260000000".isValidPhoneNumber())
    println("+2126000000001".isValidPhoneNumber())
    println("+21260000000a".isValidPhoneNumber())

    println(1200.0.toDH())



    //Une fonction qui reçoit une fonction
    val grosses = filtrerCommandes(commandes) { c -> c.mentantTotal() > 1000 }
    println(grosses.size)

    val safi = filtrerCommandes(commandes) { it.client.ville == "Safi" }
    println(safi.size)

    val payees = filtrerCommandes(commandes, ::estPayee)
    println(payees.size)
}


