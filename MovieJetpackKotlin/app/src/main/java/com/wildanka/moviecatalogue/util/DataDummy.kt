package com.wildanka.moviecatalogue.util

import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteMovie
import com.wildanka.moviecatalogue.data.datasource.local.entity.FavoriteTVShow
import com.wildanka.moviecatalogue.data.datasource.local.entity.MovieData
import com.wildanka.moviecatalogue.domain.entity.Genre
import com.wildanka.moviecatalogue.domain.entity.MovieDetail
import com.wildanka.moviecatalogue.data.datasource.local.entity.TVShowData

object DataDummy {

    fun generateRemoteDummyMovies(): MutableList<MovieData> {
        val movies = ArrayList<MovieData>()

        movies.add(
            MovieData(
                "460465",
                2145,
                "Mortal Kombat",
                "2021-04-07",
                7.8,
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "en",
                "4870.197",
                false
            )
        )
        movies.add(
            MovieData(
                "399566",
                5301,
                "Godzilla vs. Kong",
                "2021-03-24",
                8.1,
                "In a time when monsters walk the Earth, humanityâ€™s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "en",
                "2341.554",
                false
            )
        )
        movies.add(
            MovieData(
                "615457",
                1204,
                "Nobody",
                "2021-03-26",
                8.5,
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor â€” a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "/6zbKgwgaaCyyBXE4Sun4oWQfQmi.jpg",
                "en",
                "1971.546",
                false
            )
        )
        movies.add(
            MovieData(
                "804435",
                62,
                "Vanquish",
                "2021-04-16",
                6.4,
                "Victoria is a young mother trying to put her dark past as a Russian drug courier behind her, but retired cop Damon forces Victoria to do his bidding by holding her daughter hostage. Now, Victoria must use guns, guts and a motorcycle to take out a series of violent gangstersâ€”or she may never see her child again.",
                "/AoWY1gkcNzabh229Icboa1Ff0BM.jpg",
                "en",
                "1758.352",
                false
            )
        )
        movies.add(
            MovieData(
                "635302",
                843,
                "Demon Slayer -Kimetsu no Yaiba- The Movie: Mugen Train",
                "2020-10-16",
                8.4,
                "TanjirÅ� Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, KyÅ�jurÅ� Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!",
                "/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
                "ja",
                "1621.079",
                false
            )
        )
        movies.add(
            MovieData(
                "635302",
                71,
                "The Unholy",
                "2021-03-31",
                5.7,
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "en",
                "1576.588",
                false
            )
        )
        movies.add(
            MovieData(
                "567189",
                572,
                "Tom Clancy's Without Remorse",
                "2021-04-29",
                7.3,
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "en",
                "1554.731",
                false
            )
        )
        movies.add(
            MovieData(
                "726684",
                259,
                "Miraculous World: Shanghai â€“ The Legend of Ladydragon",
                "2021-04-04",
                7.8,
                "To join Adrien in Shanghai, Marinette is going to visit her uncle Wang who is celebrating his anniversary. But, as soon as she arrives in China, her purse gets stolen with Tikki inside, whom she needs to secretly transform into Ladybug! Without money and alone in the immense city, Marinette accepts the help of a young and resourceful girl, Fei. The two girls will ally and discover the existence of a new magical jewel, the Prodigious. Hawk Moth, also present in Shanghai, seeks to finding it since a long time...",
                "/msI5a9TPnepx47JUb2vl88hb80R.jpg",
                "en",
                "1470.251",
                false
            )
        )
        movies.add(
            MovieData(
                "791373",
                5319,
                "Zack Snyder's Justice League",
                "2021-03-18",
                8.5,
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "en",
                "1368.848",
                false
            )
        )
        movies.add(
            MovieData(
                "527774",
                2665,
                "Raya and the Last Dragon",
                "2021-03-03",
                8.2,
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and itâ€™s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "en",
                "1176.897",
                false
            )
        )
        movies.add(
            MovieData(
                "634528",
                383,
                "The Marksman",
                "2021-01-15",
                7.5,
                "Jim Hansonâ€™s quiet life is suddenly disturbed by two people crossing the US/Mexico border â€“ a woman and her young son â€“ desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boyâ€™s reluctant defender. He embraces his role as Miguelâ€™s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "/6vcDalR50RWa309vBH1NLmG2rjQ.jpg",
                "en",
                "1151.528",
                false
            )
        )
        movies.add(
            MovieData(
                "813258",
                523,
                "Thunder Force",
                "2021-04-09",
                5.8,
                "In a world where supervillains are commonplace, two estranged childhood best friends reunite after one devises a treatment that gives them powers to protect their city.",
                "/duK11VQd4UPDa7UJrgrGx90xJOx.jpg",
                "en",
                "1125.663",
                false
            )
        )
        movies.add(
            MovieData(
                "634528",
                73,
                "Monster Pets: A Hotel Transylvania Short",
                "2021-01-15",
                7.7,
                "Drac tries out some new monster pets to help occupy Tinkles for playtime.",
                "/dkokENeY5Ka30BFgWAqk14mbnGs.jpg",
                "en",
                "1151.528",
                false
            )
        )
        movies.add(
            MovieData(
                "736069",
                149,
                "Justice Society: World War II",
                "2021-04-27",
                8.2,
                "While speeding off to help in an impromptu battle, The Flash blazes and rips through time, only to find himself dropped into the middle of World War II. Itâ€™s here that The Flash meets Wonder Woman and her top secret team, known as the Justice Society of America. Amidst the raging tides of war, gripping combat and the velocity of valor, The Flash must fight to return to his own timeline.",
                "/e4REOC6CZW8J6FslA4nRvdQXFXR.jpg",
                "en",
                "897.966",
                false
            )
        )
        movies.add(
            MovieData(
                "412656",
                523,
                "Chaos Walking",
                "2021-01-15",
                7.3,
                "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                "en",
                "1151.528",
                false
            )
        )
        movies.add(
            MovieData(
                "464052",
                5057,
                "Wonder Woman 1984",
                "2021-12-16",
                6.8,
                "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy.",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "en",
                "740.491",
                false
            )
        )
        movies.add(
            MovieData(
                "458576",
                1591,
                "Monster Hunter",
                "2020-12-03",
                7.1,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "en",
                "704.828",
                false
            )
        )
        movies.add(
            MovieData(
                "458576",
                1591,
                "Monster Hunter",
                "2020-12-03",
                7.1,
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "en",
                "704.828",
                false
            )
        )
        movies.add(
            MovieData(
                "793723",
                365,
                "Sentinelle",
                "2021-03-05",
                6.0,
                "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                "/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
                "en",
                "696.217",
                false
            )
        )
        movies.add(
            MovieData(
                "647302",
                3,
                "Benny Loves You",
                "2021-05-07",
                7.0,
                "Jack, a man desperate to improve his life throws away his beloved childhood plush, Benny. Itâ€™s a move that has disastrous consequences when Benny springs to life with deadly intentions!",
                "/mQ8vALvqA0z0qglG3gI6xpVcslo.jpg",
                "en",
                "655.951",
                false
            )
        )
        movies.add(
            MovieData(
                "544401",
                573,
                "Cherry",
                "2021-02-26",
                7.5,
                "Cherry drifts from college dropout to army medic in Iraq - anchored only by his true love, Emily. But after returning from the war with PTSD, his life spirals into drugs and crime as he struggles to find his place in the world.",
                "/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg",
                "en",
                "652.926",
                false
            )
        )

        return movies
    }

    fun generateRemoteDummyTVShow(): List<TVShowData> {
        val tvShows = ArrayList<TVShowData>()

        tvShows.add(
            TVShowData(
                "88396",
                5360,
                "The Falcon and the Winter Soldier",
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                7.9,
                "Following the events of â€œAvengers: Endgameâ€�, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "en",
                "1829.941"
            )
        )
        tvShows.add(
            TVShowData(
                "95557",
                1416,
                "Invincible",
                "Invincible",
                "2021-03-26",
                8.9,
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his fatherâ€™s tutelage.",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "en",
                "1829.941"
            )
        )
        tvShows.add(
            TVShowData(
                "60735",
                7545,
                "The Flash",
                "The Flash",
                "2014-10-07",
                7.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "en",
                "1254.767"
            )
        )

        return tvShows
    }

    fun generateLocalDummyFavoriteMovies(): List<FavoriteMovie> {
        val genres = ArrayList<Genre>()
        genres.add(Genre("28", "tes"))
        genres.add(Genre("14", "tes"))
        genres.add(Genre("12", "tes"))
        genres.add(Genre("878", "tes"))

        val movies = ArrayList<FavoriteMovie>()

        movies.add(
            FavoriteMovie(
                "460465",
                false,
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "Action, Fantasy, Adventure, Science Fiction, ",
                "https://www.mortalkombatmovie.net",
                "2021-04-07",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "5419.678",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "en",
                "50115000",
                "110",
                "Released",
                "Get over here.",
                "Mortal Kombat",
                7.7,
                "2240"
            )
        )
        movies.add(
            FavoriteMovie(
                "460465",
                false,
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "Action, Fantasy, Adventure, Science Fiction, ",
                "https://www.mortalkombatmovie.net",
                "2021-04-07",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "5419.678",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "en",
                "50115000",
                "110",
                "Released",
                "Get over here.",
                "Mortal Kombat",
                7.7,
                "2240"
            )
        )
        movies.add(
            FavoriteMovie(
                "460465",
                false,
                "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                "Action, Fantasy, Adventure, Science Fiction, ",
                "https://www.mortalkombatmovie.net",
                "2021-04-07",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "5419.678",
                "/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg",
                "en",
                "50115000",
                "110",
                "Released",
                "Get over here.",
                "Mortal Kombat",
                7.7,
                "2240"
            )
        )

        return movies
    }

    fun generateLocalDummyMovieDetail(): FavoriteMovie {
        return generateLocalDummyFavoriteMovies()[0]
    }

    fun generateLocalDummyFavoriteTVShow(): List<FavoriteTVShow> {
        val genres = ArrayList<Genre>()
        genres.add(Genre("28", "tes"))
        genres.add(Genre("14", "tes"))
        genres.add(Genre("12", "tes"))
        genres.add(Genre("878", "tes"))

        val tvShows = ArrayList<FavoriteTVShow>()

        tvShows.add(
            FavoriteTVShow(
                "88396",
                "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                "Action, Fantasy, Adventure, Science Fiction, ",
                "",
                "en",
                "Following the events of â€œAvengers: Endgameâ€�, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "1829.941",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",
                "",
                "",
                "",
                "",
                "",
                "The Falcon and the Winter Soldier",
                7.9,
                "5360"
            )
        )
        tvShows.add(
            FavoriteTVShow(
                "95557",
                "/6UH52Fmau8RPsMAbQbjwN3wJSCj.jpg",
                "Action, Fantasy, Adventure, Science Fiction, ",
                "",
                "en",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his fatherâ€™s tutelage.",
                "1744.687",
                "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "2021-03-26",
                "",
                "",
                "",
                "",
                "",
                "Invincible",
                8.9,
                "1416"
            )
        )
        tvShows.add(
            FavoriteTVShow(
                "60735",
                "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "Action, Fantasy, Adventure, Science Fiction, ",
                "",
                "en",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "1254.767",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                "",
                "",
                "",
                "",
                "",
                "The Flash",
                7.7,
                "7545"
            )
        )

        return tvShows
    }

    fun generateLocalDummyTVShowDetail(): FavoriteTVShow {
        return generateLocalDummyFavoriteTVShow()[0]
    }

    fun generateRemoteDummyMovieDetail(movieId: String): MovieDetail {
        val genres = ArrayList<Genre>()

        genres.add(Genre("28", "tes"))
        genres.add(Genre("14", "tes"))
        genres.add(Genre("12", "tes"))
        genres.add(Genre("878", "tes"))


        return MovieDetail(
            "123",
            false,
            "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            genres,
            "homePageUrl",
            "en",
            "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
            "4870.197",
            "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
            "2021-04-07",
            "revenue",
            "duration",
            "status",
            "tagline",
            "Mortal Kombat",
            7.8,
            "2145"
        )
    }
}