package com.wildanka.moviecatalogue

import com.wildanka.moviecatalogue.entity.Movie
import com.wildanka.moviecatalogue.entity.TvShow

class MoviesRepository() {
    private val movieList = mutableListOf<Movie>()
    private val tvShowList = mutableListOf<TvShow>()

    fun getAllMovies(): MutableList<Movie> {
        generateMovieData()
        return movieList
    }
    fun getAllTVShow(): MutableList<TvShow> {
        generateTvShowData()
        return tvShowList
    }

    private fun generateMovieData(){
        movieList.add(Movie(
            "A Star Is Born",
            "October 5, 2018",
            "75",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just\n" +
                    "            about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even…\n" +
                    "        ",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just\n" +
                    "            about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even\n" +
                    "            as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an\n" +
                    "            ongoing battle with his own internal demons.\n" +
                    "        ",
            R.drawable.poster_a_start_is_born
        ))
        movieList.add(Movie(
            "Alita: Battle Angel",
            "January 31, 2019",
            "66",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in\n" +
                    "            by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and…\n" +
                    "        ",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in\n" +
                    "            by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and\n" +
                    "            soul of a young woman with an extraordinary past.\n" +
                    "        ",
            R.drawable.poster_alita
        ))
        movieList.add(Movie(
            "Aquaman",
            "December 21, 2018",
            "83",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the\n" +
                    "            power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people…\n" +
                    "        ",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the\n" +
                    "            power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people\n" +
                    "            and then the surface world. Standing in his way is Arthur Curry, Orm\\'s half-human, half-Atlantean brother\n" +
                    "            and true heir to the throne.",
            R.drawable.poster_aquaman
        ))
        movieList.add(Movie(
            "Bohemian Rhapsody",
            "October 24, 2018",
            "70",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the\n" +
                    "            music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant\n" +
                    "            classics.…\n" +
                    "        ",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the\n" +
                    "            music world by storm when they form the rock \\'n\\' roll band Queen in 1970. Hit songs become instant\n" +
                    "            classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its\n" +
                    "            greatest challenge yet – finding a way to keep the band together amid the success and excess.\n" +
                    "        ",
            R.drawable.poster_bohemian
        ))
        movieList.add(Movie(
            "Cold Pursuit",
            "February 7, 2019",
            "81",
            "Nels Coxman\\'s quiet life comes crashing down when his beloved son dies under mysterious circumstances.\n" +
                    "            His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug\n" +
                    "            lord …\n" +
                    "        ",
            "Nels Coxman\\'s quiet life comes crashing down when his beloved son dies under mysterious circumstances.\n" +
                    "            His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug\n" +
                    "            lord and his inner circle.\n" +
                    "        ",
            R.drawable.poster_cold_persuit
        ))
        movieList.add(Movie(
            "Creed II",
            "November 21, 2018",
            "65",
            "Between personal obligations and training for his next big fight against an opponent with ties to his\n" +
                    "            family\\'s past, Adonis Creed is up against the challenge of his life.\n" +
                    "        ",
            "Between personal obligations and training for his next big fight against an opponent with ties to his\n" +
                    "            family\\'s past, Adonis Creed is up against the challenge of his life.\n" +
                    "        ",
            R.drawable.poster_creed
        ))
        movieList.add(Movie(
            "Fantastic Beasts: The Crimes of Grindelwald",
            "November 14, 2018",
            "69",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating\n" +
                    "            wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once\n" +
                    "            called…\n" +
                    "        ",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating\n" +
                    "            wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once\n" +
                    "            called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who\n" +
                    "            had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the\n" +
                    "            dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and\n" +
                    "            family, in an increasingly divided wizarding world.\n" +
                    "        ",
            R.drawable.poster_crimes
        ))
        movieList.add(Movie(
            "Glass",
            "January 16, 2019",
            "71",
            "In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track\n" +
                    "            Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of…\n" +
                    "        ",
            "In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track\n" +
                    "            Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of\n" +
                    "            Elijah Price emerges as an orchestrator who holds secrets critical to both men.\n" +
                    "        ",
            R.drawable.poster_glass
        ))
        movieList.add(Movie(
            "How to Train Your Dragon : The Hidden World",
            "January 3, 2019",
            "78",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed,\n" +
                    "            elusive mate draws the Night Fury away. When danger mounts at home and Hiccup\\'s reign as village chief is\n" +
                    "            tested…\n" +
                    "        \n" +
                    "            Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of…\n" +
                    "        ",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed,\n" +
                    "            elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is\n" +
                    "            tested, both dragon and rider must make impossible decisions to save their kind.\n" +
                    "        ",
            R.drawable.poster_how_to_train
        ))
        movieList.add(Movie(
            "Avengers : Infinity Wars",
            "April 27, 2018",
            "83",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one\n" +
                    "            hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy…\n" +
                    "        ",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one\n" +
                    "            hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy,\n" +
                    "            his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his\n" +
                    "            twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate\n" +
                    "            of Earth and existence itself has never been more uncertain.\n" +
                    "        ",
            R.drawable.poster_infinity_war
        ))
        movieList.add(Movie(
            "Mary Queen of Scots",
            "December 7, 2018",
            "66",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and\n" +
                    "            menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the\n" +
                    "            English…\n" +
                    "        ",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and\n" +
                    "            menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the\n" +
                    "            English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They\n" +
                    "            experience the bitter cost of power, until their tragic fate is finally fulfilled. Featured Crew\n" +
                    "        ",
            R.drawable.poster_marry_queen
        ))
        movieList.add(Movie(
            "Master Z: Ip Man Legacy",
            "December 20, 2018",
            "50",
            "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his\n" +
                    "            business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar…\n" +
                    "        ",
            "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his\n" +
                    "            business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar\n" +
                    "            district. Tin Chi fights hard with Wing Chun and earns respect.\n" +
                    "        ",
            R.drawable.poster_master_z
        ))
        movieList.add(Movie(
            "Mortal Engines",
            "November 27, 2018",
            "67",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other\n" +
                    "            in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom…\n" +
                    "        ",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other\n" +
                    "            in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom\n" +
                    "            Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the\n" +
                    "            course of his life forever.\n" +
                    "        ",
            R.drawable.poster_mortal_engines
        ))
        movieList.add(Movie(
            "Overlord",
            "November 1, 2018",
            "59",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their\n" +
                    "            aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of\n" +
                    "            Normandy.…\n" +
                    "        ",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their\n" +
                    "            aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of\n" +
                    "            Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the\n" +
                    "            Nazi troops that patrol the village, they also must fight against something else.\n" +
                    "        ",
            R.drawable.poster_overlord
        ))
        movieList.add(Movie(
            "Ralph Breaks the Internet",
            "November 20, 2018",
            "67",
            "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the\n" +
                    "            World Wide Web in search of a replacement part to save Vanellope\\'s video game, \\\"Sugar Rush.\\\" In way over\n" +
                    "            their…\n" +
                    "        ",
            "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the\n" +
                    "            World Wide Web in search of a replacement part to save Vanellope\\'s video game, \\\"Sugar Rush.\\\" In way over\n" +
                    "            their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate\n" +
                    "            their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of\n" +
                    "            trend-making site BuzzzTube.\n" +
                    "        ",
            R.drawable.poster_ralph
        ))
        movieList.add(Movie(
            "Robin Hood",
            "November 20, 2018",
            "72",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English\n" +
                    "            crown.\n" +
                    "        ",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English\n" +
                    "            crown.\n" +
                    "        ",
            R.drawable.poster_robin_hood
        ))
        movieList.add(Movie(
            "Serenity",
            "January 24, 2019",
            "57",
            "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth\n" +
                    "            Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea\n" +
                    "            for…\n" +
                    "        ",
            "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth\n" +
                    "            Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea\n" +
                    "            for help.\n" +
                    "        ",
            R.drawable.poster_serenity
        ))
        movieList.add(Movie(
            "Spiderman",
            "December 14, 2018",
            "85",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson\n" +
                    "            \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this\n" +
                    "            dimension.\n" +
                    "        ",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson\n" +
                    "            \\\"Kingpin\\\" Fisk uses a super collider, others from across the Spider-Verse are transported to this\n" +
                    "            dimension.\n" +
                    "        ",
            R.drawable.poster_spiderman
        ))
        movieList.add(Movie(
            "52",
            "December 27, 2018",
            "48",
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a\n" +
                    "            half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting,\n" +
                    "            unbreakable love,…\n" +
                    "        ",
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a\n" +
                    "            half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting,\n" +
                    "            unbreakable love, and legendary miracles.\n" +
                    "        ",
            R.drawable.poster_a_start_is_born
        ))
    }

    private fun generateTvShowData(){
        tvShowList.add(TvShow(
            "Arrow",
            "October 10, 2012",
            "75",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He\n" +
                    "            returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a…\n" +
                    "        ",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He\n" +
                    "            returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a\n" +
                    "            bow",
            R.drawable.poster_arrow
        ))
        tvShowList.add(TvShow(
            "Doom Patrol",
            "February 15, 2019",
            "58",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also\n" +
                    "            left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief,…\n" +
                    "        ",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also\n" +
                    "            left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who\n" +
                    "            brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what\n" +
                    "            they find",
            R.drawable.poster_doom_patrol
        ))
        tvShowList.add(TvShow(
            "Dragon Ball",
            "February 26, 1986",
            "59",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku.\n" +
                    "            Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his…\n" +
                    "        ",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku.\n" +
                    "            Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his\n" +
                    "            own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon\n" +
                    "            balls brought her to Goku\\'s home. Together, they set off to find all seven dragon balls in an adventure\n" +
                    "            that would change Goku\\'s life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin,\n" +
                    "            Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball\n" +
                    "            GT.",
            R.drawable.poster_dragon_ball
        ))
        tvShowList.add(TvShow(
            "Fairy Tail",
            "October 12, 2009",
            "73",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she\n" +
                    "            meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any\n" +
                    "            ordinary…",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she\n" +
                    "            meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\\'t just any\n" +
                    "            ordinary kid, he\\'s a member of one of the world\\'s most infamous mage guilds: Fairy Tail.\n" +
                    "        ",
            R.drawable.poster_fairytail
        ))
        tvShowList.add(TvShow(
            "Family Guy",
            "January 31, 1999",
            "67",
            "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the\n" +
                    "            dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant\n" +
                    "            but…",
            "Sick, twisted, politically incorrect and Freakin\\' Sweet animated series featuring the adventures of the\n" +
                    "            dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant\n" +
                    "            but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most\n" +
                    "            unpopular girl in town) and Chris (the middle kid, he\\'s not very bright but has a passion for movies). The\n" +
                    "            final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check\n" +
                    "            whilst sipping Martinis and sorting through his own life issues.\n" +
                    "        ",
            R.drawable.poster_family_guy
        ))
        tvShowList.add(TvShow(
            "The Flash",
            "October 7, 2014",
            "65",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and\n" +
                    "            falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move…\n" +
                    "        ",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and\n" +
                    "            falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move\n" +
                    "            through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry\n" +
                    "            is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator\n" +
                    "            explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and\n" +
                    "            dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry\n" +
                    "            is literally the fastest man alive, but it won\\'t be long before the world learns what Barry Allen has\n" +
                    "            become…The Flash.",
            R.drawable.poster_flash
        ))
        tvShowList.add(TvShow(
            "Game of Thrones",
            "April 17, 2011",
            "67",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads\n" +
                    "            to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected…\n" +
                    "        ",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads\n" +
                    "            to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected\n" +
                    "            military order of misfits, the Night\\'s Watch, is all that stands between the realms of men and icy horrors\n" +
                    "            beyond.",
            R.drawable.poster_god
        ))
        tvShowList.add(TvShow(
            "Gotham",
            "September 22, 2014",
            "82",
            "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the\n" +
                    "            crime world\\'s greatest foes, a man whose reputation is synonymous with law and order. But what is known…\n" +
                    "        ",
            "Before there was Batman, there was GOTHAM.\n" +
                    "            Everyone knows the name Commissioner Gordon. He is one of the crime world\\'s greatest foes, a man whose\n" +
                    "            reputation is synonymous with law and order. But what is known of Gordon\\'s story and his rise from rookie\n" +
                    "            detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that\n" +
                    "            secretly ruled Gotham City, the spawning ground of the world\\'s most iconic villains? And what circumstances\n" +
                    "            created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face\n" +
                    "            and The Joker?",
            R.drawable.poster_gotham
        ))
        tvShowList.add(TvShow(
            "Grey\'s Anatomy",
            "March 27, 2005",
            "68",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial\n" +
                    "            Hospital.",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial\n" +
                    "            Hospital.",
            R.drawable.poster_grey_anatomy
        ))
        tvShowList.add(TvShow(
            "Hanna",
            "March 28, 2019",
            "62",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the\n" +
                    "            relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the…\n" +
                    "        ",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the\n" +
                    "            relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the\n" +
                    "            2011 Joe Wright film.",
            R.drawable.poster_hanna
        ))
        tvShowList.add(TvShow(
            "Iron Fist",
            "March 17, 2017",
            "58",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks\n" +
                    "            to reclaim his past and fulfill his destiny.",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks\n" +
                    "            to reclaim his past and fulfill his destiny.",
            R.drawable.poster_iron_fist
        ))
        tvShowList.add(TvShow(
            "Naruto Shippuden",
            "February 15, 2007",
            "60",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around\n" +
                    "            an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the…\n" +
                    "        ",
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around\n" +
                    "            an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the\n" +
                    "            grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village\n" +
                    "            of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few\n" +
                    "            (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.\n" +
                    "        ",
            R.drawable.poster_naruto_shipudden
        ))
        tvShowList.add(TvShow(
            "NCIS",
            "September 23, 2003",
            "75",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any\n" +
                    "            crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or\n" +
                    "            position.\n" +
                    "        ",
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any\n" +
                    "            crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or\n" +
                    "            position.",
            R.drawable.poster_ncis
        ))
        tvShowList.add(TvShow(
            "Riverdale",
            "January 26, 2017",
            "67",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their\n" +
                    "            friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath\n" +
                    "            Riverdale’s wholesome…",
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their\n" +
                    "            friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath\n" +
                    "            Riverdale’s wholesome facade.",
            R.drawable.poster_riverdale
        ))
        tvShowList.add(TvShow(
            "Shameless",
            "January 9, 2011",
            "69",
            "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without\n" +
                    "            him would be… perhaps better off. When Frank\\'s not at the bar spending what little money they have, he…\n" +
                    "        ",
            "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without\n" +
                    "            him would be… perhaps better off. When Frank\\'s not at the bar spending what little money they have, he\\'s\n" +
                    "            passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any\n" +
                    "            family you know, but they make no apologies for being exactly who they are.",
            R.drawable.poster_shameless
        ))
        tvShowList.add(TvShow(
            "Supergirl",
            "October 26, 2015",
            "78",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent\n" +
                    "            away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to…\n" +
                    "        ",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent\n" +
                    "            away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to\n" +
                    "            be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her\n" +
                    "            journey of heroism.",
            R.drawable.poster_supergirl
        ))
        tvShowList.add(TvShow(
            "Supernatural : Wrestle Your Demons",
            "September 13, 2005",
            "57",
            "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural\n" +
                    "            force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that…\n" +
                    "        ",
            "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural\n" +
                    "            force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that\n" +
                    "            lives in the dark corners and on the back roads of America … and he taught them how to kill it. Now, the\n" +
                    "            Winchester brothers crisscross the country in their \\'67 Chevy Impala, battling every kind of supernatural\n" +
                    "            threat they encounter along the way.",
            R.drawable.poster_supernatural
        ))
        tvShowList.add(TvShow(
            "The Simpsons",
            "December 17, 1989",
            "73",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of\n" +
                    "            the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the…\n" +
                    "        ",
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of\n" +
                    "            the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the\n" +
                    "            beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The\n" +
                    "            show has also made name for itself in its fearless satirical take on politics, media and American life in\n" +
                    "            general.",
            R.drawable.poster_the_simpson
        ))
        tvShowList.add(TvShow(
            "The Umbrella Academy",
            "February 15, 2019",
            "71",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father\\'s death, the\n" +
                    "            threat of the apocalypse and more.",
            "A dysfunctional family of superheroes comes together to solve the mystery of their father\\'s death, the\n" +
                    "            threat of the apocalypse and more.",
            R.drawable.poster_the_umbrella
        ))
        tvShowList.add(TvShow(
            "The Walking Dead",
            "October 31, 2010",
            "79",
            "Sheriff\'s deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by\n" +
                    "            flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.\n" +
                    "        ",
            "Sheriff\'s deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by\n" +
                    "            flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.\n" +
                    "        ",
            R.drawable.poster_the_walking_dead
        ))
    }
}