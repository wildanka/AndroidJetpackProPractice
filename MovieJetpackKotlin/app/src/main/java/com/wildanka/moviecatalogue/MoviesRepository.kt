package com.wildanka.moviecatalogue

import com.wildanka.moviecatalogue.model.entity.Movie
import com.wildanka.moviecatalogue.model.entity.TvShow

class MoviesRepository {
    private val movieList = mutableListOf<Movie>()
    private val tvShowList = mutableListOf<TvShow>()

    fun getAllMovies(): MutableList<Movie>? {
        generateMovieData()
        return movieList
    }
    fun getAllTVShow(): MutableList<TvShow>? {
        generateTvShowData()
        return tvShowList
    }

    private fun generateMovieData(){
        movieList.add(
            Movie(
                "A Star Is Born",
                "October 5, 2018",
                "75",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just " +
                        "about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even… " +
                        "",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just " +
                        "about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even " +
                        "as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an " +
                        "ongoing battle with his own internal demons. " +
                        "",
                R.drawable.poster_a_start_is_born
            )
        )
        movieList.add(
            Movie(
                "Alita: Battle Angel",
                "January 31, 2019",
                "66",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in " +
                        "by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and… " +
                        "",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in " +
                        "by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and " +
                        "soul of a young woman with an extraordinary past. " +
                        "",
                R.drawable.poster_alita
            )
        )
        movieList.add(
            Movie(
                "Aquaman",
                "December 21, 2018",
                "83",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the " +
                        "power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people… " +
                        "",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the " +
                        "power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people " +
                        "and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother " +
                        "and true heir to the throne.",
                R.drawable.poster_aquaman
            )
        )
        movieList.add(
            Movie(
                "Bohemian Rhapsody",
                "October 24, 2018",
                "70",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the " +
                        "music world by storm when they form the rock \'n\' roll band Queen in 1970. Hit songs become instant " +
                        "classics.… " +
                        "",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the " +
                        "music world by storm when they form the rock \'n\' roll band Queen in 1970. Hit songs become instant " +
                        "classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its " +
                        "greatest challenge yet – finding a way to keep the band together amid the success and excess. " +
                        "",
                R.drawable.poster_bohemian
            )
        )
        movieList.add(
            Movie(
                "Cold Pursuit",
                "February 7, 2019",
                "81",
                "Nels Coxman's quiet life comes crashing down when his beloved son dies under mysterious circumstances. " +
                        "His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug " +
                        "lord … " +
                        "",
                "Nels Coxman's quiet life comes crashing down when his beloved son dies under mysterious circumstances. " +
                        "His search for the truth soon becomes a quest for revenge as he seeks coldblooded justice against a drug " +
                        "lord and his inner circle. ",
                R.drawable.poster_cold_persuit
            )
        )
        movieList.add(
            Movie(
                "Creed II",
                "November 21, 2018",
                "65",
                "Between personal obligations and training for his next big fight against an opponent with ties to his " +
                        "family's past, Adonis Creed is up against the challenge of his life. ",
                "Between personal obligations and training for his next big fight against an opponent with ties to his " +
                        "family's past, Adonis Creed is up against the challenge of his life. ",
                R.drawable.poster_creed
            )
        )
        movieList.add(
            Movie(
                "Fantastic Beasts: The Crimes of Grindelwald",
                "November 14, 2018",
                "69",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating " +
                        "wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once " +
                        "called… " +
                        "",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating " +
                        "wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once " +
                        "called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who " +
                        "had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the " +
                        "dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and " +
                        "family, in an increasingly divided wizarding world. ",
                R.drawable.poster_crimes
            )
        )
        movieList.add(
            Movie(
                "Glass",
                "January 16, 2019",
                "71",
                "In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track " +
                        "Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of… ",
                "In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track " +
                        "Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of " +
                        "Elijah Price emerges as an orchestrator who holds secrets critical to both men. ",
                R.drawable.poster_glass
            )
        )
        movieList.add(
            Movie(
                "How to Train Your Dragon : The Hidden World",
                "January 3, 2019",
                "78",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, " +
                        "elusive mate draws the Night Fury away. When danger mounts at home and Hiccup\'s reign as village chief is " +
                        "tested… " +
                        "Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of…",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, " +
                        "elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is " +
                        "tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.poster_how_to_train
            )
        )
        movieList.add(
            Movie(
                "Avengers : Infinity Wars",
                "April 27, 2018",
                "83",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one " +
                        "hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy… ",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one " +
                        "hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, " +
                        "his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his " +
                        "twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate " +
                        "of Earth and existence itself has never been more uncertain.",
                R.drawable.poster_infinity_war
            )
        )
        movieList.add(
            Movie(
                "Mary Queen of Scots",
                "December 7, 2018",
                "66",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and " +
                        "menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the " +
                        "English…",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and " +
                        "menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the " +
                        "English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They " +
                        "experience the bitter cost of power, until their tragic fate is finally fulfilled. Featured Crew",
                R.drawable.poster_marry_queen
            )
        )
        movieList.add(
            Movie(
                "Master Z: Ip Man Legacy",
                "December 20, 2018",
                "50",
                "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his " +
                        "business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar… ",
                "After being defeated by Ip Man, Cheung Tin Chi is attempting to keep a low profile. While going about his " +
                        "business, he gets into a fight with a foreigner by the name of Davidson, who is a big boss behind the bar " +
                        "district. Tin Chi fights hard with Wing Chun and earns respect. ",
                R.drawable.poster_master_z
            )
        )
        movieList.add(
            Movie(
                "Mortal Engines",
                "November 27, 2018",
                "67",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other " +
                        "in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom… ",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other " +
                        "in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom " +
                        "Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the " +
                        "course of his life forever.",
                R.drawable.poster_mortal_engines
            )
        )
        movieList.add(
            Movie(
                "Overlord",
                "November 1, 2018",
                "59",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their " +
                        "aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of " +
                        "Normandy.… " +
                        "",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their " +
                        "aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of " +
                        "Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the " +
                        "Nazi troops that patrol the village, they also must fight against something else.",
                R.drawable.poster_overlord
            )
        )
        movieList.add(
            Movie(
                "Ralph Breaks the Internet",
                "November 20, 2018",
                "67",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the " +
                        "World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over " +
                        "their…",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the " +
                        "World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over " +
                        "their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate " +
                        "their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of " +
                        "trend-making site BuzzzTube.",
                R.drawable.poster_ralph
            )
        )
        movieList.add(
            Movie(
                "Robin Hood",
                "November 20, 2018",
                "72",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English " +
                        "crown. ",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English " +
                        "crown. ",
                R.drawable.poster_robin_hood
            )
        )
        movieList.add(
            Movie(
                "Serenity",
                "January 24, 2019",
                "57",
                "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth " +
                        "Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea " +
                        "for… " +
                        "",
                "Baker Dill is a fishing boat captain leading tours off a tranquil, tropical enclave called Plymouth " +
                        "Island. His quiet life is shattered, however, when his ex-wife Karen tracks him down with a desperate plea " +
                        "for help. ",
                R.drawable.poster_serenity
            )
        )
        movieList.add(
            Movie(
                "Spiderman",
                "December 14, 2018",
                "85",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson " +
                        "\"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this " +
                        "dimension. ",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson " +
                        "\"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this " +
                        "dimension.",
                R.drawable.poster_spiderman
            )
        )
        movieList.add(
            Movie(
                "T-34",
                "December 27, 2018",
                "48",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a " +
                        "            half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, " +
                        "            unbreakable love,…",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a " +
                        "half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, " +
                        "unbreakable love, and legendary miracles.",
                R.drawable.poster_t34
            )
        )
    }

    private fun generateTvShowData(){
        tvShowList.add(
            TvShow(
                "Arrow",
                "October 10, 2012",
                "75",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He " +
                        "returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a… " +
                        "",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He " +
                        "returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a " +
                        "bow",
                R.drawable.poster_arrow
            )
        )
        tvShowList.add(
            TvShow(
                "Doom Patrol",
                "February 15, 2019",
                "58",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also " +
                        "left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief,… ",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also " +
                        "left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who " +
                        "brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what " +
                        "they find",
                R.drawable.poster_doom_patrol
            )
        )
        tvShowList.add(
            TvShow(
                "Dragon Ball",
                "February 26, 1986",
                "59",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. " +
                        "Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his… ",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. " +
                        "Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his " +
                        "own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon " +
                        "balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure " +
                        "that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, " +
                        "Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball " +
                        "GT.",
                R.drawable.poster_dragon_ball
            )
        )
        tvShowList.add(
            TvShow(
                "Fairy Tail",
                "October 12, 2009",
                "73",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\'t just any ordinary…",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn\'t just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.poster_fairytail
            )
        )
        tvShowList.add(
            TvShow(
                "Family Guy",
                "January 31, 1999",
                "67",
                "Sick, twisted, politically incorrect and Freakin\' Sweet animated series featuring the adventures of the" +
                        " dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant" +
                        " but…",
                "Sick, twisted, politically incorrect and Freakin\' Sweet animated series featuring the adventures of the " +
                        "dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant " +
                        "but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                R.drawable.poster_family_guy
            )
        )
        tvShowList.add(
            TvShow(
                "The Flash",
                "October 7, 2014",
                "65",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move… ",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion — and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won\'t be long before the world learns what Barry Allen has become…The Flash.",
                R.drawable.poster_flash
            )
        )
        tvShowList.add(
            TvShow(
                "Game of Thrones",
                "April 17, 2011",
                "67",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected…",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.poster_god
            )
        )
        tvShowList.add(
            TvShow(
                "Gotham",
                "September 22, 2014",
                "82",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known…",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                R.drawable.poster_gotham
            )
        )
        tvShowList.add(
            TvShow(
                "Grey\'s Anatomy",
                "March 27, 2005",
                "68",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                R.drawable.poster_grey_anatomy
            )
        )
        tvShowList.add(
            TvShow(
                "Hanna",
                "March 28, 2019",
                "62",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the… ",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                R.drawable.poster_hanna
            )
        )
        tvShowList.add(
            TvShow(
                "Iron Fist",
                "March 17, 2017",
                "58",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                R.drawable.poster_iron_fist
            )
        )
        tvShowList.add(
            TvShow(
                "Naruto Shippuden",
                "February 15, 2007",
                "60",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the…",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.poster_naruto_shipudden
            )
        )
        tvShowList.add(
            TvShow(
                "NCIS",
                "September 23, 2003",
                "75",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                R.drawable.poster_ncis
            )
        )
        tvShowList.add(
            TvShow(
                "Riverdale",
                "January 26, 2017",
                "67",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                R.drawable.poster_riverdale
            )
        )
        tvShowList.add(
            TvShow(
                "Shameless",
                "January 9, 2011",
                "69",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be… perhaps better off. When Frank's not at the bar spending what little money they have, he…",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be… perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any  family you know, but they make no apologies for being exactly who they are.",
                R.drawable.poster_shameless
            )
        )
        tvShowList.add(
            TvShow(
                "Supergirl",
                "October 26, 2015",
                "78",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to…",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                R.drawable.poster_supergirl
            )
        )
        tvShowList.add(
            TvShow(
                "Supernatural : Wrestle Your Demons",
                "September 13, 2005",
                "57",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that…",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America … and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their \'67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                R.drawable.poster_supernatural
            )
        )
        tvShowList.add(
            TvShow(
                "The Simpsons",
                "December 17, 1989",
                "73",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the…",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                R.drawable.poster_the_simpson
            )
        )
        tvShowList.add(
            TvShow(
                "The Umbrella Academy",
                "February 15, 2019",
                "71",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                R.drawable.poster_the_umbrella
            )
        )
        tvShowList.add(
            TvShow(
                "The Walking Dead",
                "October 31, 2010",
                "79",
                "Sheriff\'s deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "Sheriff\'s deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                R.drawable.poster_the_walking_dead
            )
        )
    }
}