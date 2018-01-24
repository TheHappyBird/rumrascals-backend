package rumrascals.backend

class BootStrap {

    def init = { servletContext ->
        def country1 = new Country(name: "Panama").save()
        def country2 = new Country(name: "Venezuela").save()
        def country3 = new Country(name: "Guyana").save()
        def country4 = new Country(name: "Guatemala").save()
        def country5 = new Country(name: "Barbados").save()
        def country6 = new Country(name: "Trinidad").save()
        def country7 = new Country(name: "Dom Rep.").save()
        def country8 = new Country(name: "Colombia").save()
        def country9 = new Country(name: "Mauritius").save()
        def country10 = new Country(name: "Indien").save()
        def country11 = new Country(name: "Puerto Rico").save()
        def country12 = new Country(name: "UK").save()

        def company1 = new Company(
                name: "Brugal & Co., C. por A.",
                foundedYear: 1888,
                foundedInCountry: country7
        ).save()

        def brand1 = new Brand(
                name: "Brugal",
                description: "A company",
                company: company1
        ).save()

        def rum1 = new Rum(
                name: "1988 Gran Reserva Familiar",
                brand: brand1,
                description: "This is a rum",
                brewedInCountry: country7,
                price: 500

        ).save()

        def rum2 = new Rum(
                name: "Añejo",
                brand: brand1,
                description: "This is also a rum",
                brewedInCountry: country7,
                price: 269
        ).save()

        def rum3 = new Rum(
                name: "Extra Viejo",
                brand: brand1,
                description: "RUM!",
                brewedInCountry: country7,
                price: 349
        ).save()

        def review1 = new Review(
                title: "Cool review",
                descriptin: "This is a review",
                review: "Samma bäsksa som Añejo, men utan den agressiva alkoholsmaken. Mer komplex smak än både Añejo och Extra Viejo.",
                rating: 3.5,
                rum: rum1
        ).save()

        def review2 = new Review(
                title: "Cool review",
                descriptin: "This is a review",
                review: "En mer agressiv alkoholsmak än Extra Viejo. Mycket bäska. Luktar väldigt lik ",
                rating: 3.0,
                rum: rum2
        ).save()

        def review3 = new Review(
                title: "Rad review",
                descriptin: "This is a review",
                review: "Smooth med en ganska liten kick. Värmande effekt med en inte alltför brännande smak. Felix: Len men med en välkomnande kick. Skulle uppskattas framför en brasa, bra att ha med på fjällvnadringar. En Chill-rom.",
                rating: 4.0,
                rum: rum3
        ).save()
    }
    def destroy = {
    }
}
