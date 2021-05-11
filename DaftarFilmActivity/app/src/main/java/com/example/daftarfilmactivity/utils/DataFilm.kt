package com.example.daftarfilmactivity.utils

import com.example.daftarfilmactivity.R.drawable
import com.example.daftarfilmactivity.data.Film
import com.example.daftarfilmactivity.data.source.local.entity.MovieEntity
import com.example.daftarfilmactivity.data.source.local.entity.TvShowEntity
import com.example.daftarfilmactivity.data.source.remote.response.DetailResponse
import com.example.daftarfilmactivity.data.source.remote.response.MovieResponse
import com.example.daftarfilmactivity.data.source.remote.response.TvShowResponse

object DataFilm {
    fun generateDummyFilm(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity("m11",
                "A Star is Born",
        "10/05/2018",
        "Drama, Romance, Music",
        "75%",
        "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
            MovieEntity("m12",
                "Alita: Battle Angle",
        "02/14/2019",
        "Action, Science Fiction, Adventure",
        "72%",
        "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movies.add(
            MovieEntity("m13",
                "Aquaman",
        "12/21/2018",
            "Action, Adventure, Fantasy",
            "69%",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg")
        )

        movies.add(
            MovieEntity("m14",
                "Bohemian Rhapsody",
        "11/02/2018",
            "Music, Drama, History",
            "80%",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )

        movies.add(
            MovieEntity("m15",
                "Cold Pursuit",
        "02/08/2019",
            "Action, Crime, Thriller",
            "57%",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg"))

        movies.add(MovieEntity("m16",
            "Creed",
        "11/25/2015",
        "Drama",
        "74%",
        "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            "https://www.themoviedb.org/t/p/w1280/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg"))

        movies.add(MovieEntity("m17",
            "Fantastic Beasts: The Crimes of Grindelwald",
        "11/16/2018",
        "Adventure, Fantasy, Drama",
        "69%",
        "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"))

        movies.add(
            MovieEntity("m18",
                "Glass",
        "01/18/2019",
            "Thriller, Drama, Science Fiction",
            "67%",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg"))

        movies.add(MovieEntity("m19",
            "How to Train Your Dragon",
        "03/26/2010",
        "Fantasy, Adventure, Animation, Family",
        "78%",
        "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
            "https://www.themoviedb.org/t/p/w1280/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg"))

        movies.add(MovieEntity("m20",
            "Avengers: Infinity War ",
        "04/27/2018",
        "Adventure, Action, Science Fiction",
        "83%",
        "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"))

        return movies
    }

    fun generateDummyTv(): ArrayList<TvShowEntity>{
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity("t11",
                "Arrow",
        "2012",
        "Crime, Drama, Mystery, Action & Adventure",
        "66%",
        "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )

        tvShow.add(TvShowEntity("t12",
                "Doom Patrol",
        "2019",
        "Sci-Fi & Fantasy, Comedy, Drama",
        "76%",
        "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg"))

        tvShow.add(TvShowEntity("t13",
                "Dragon Ball",
        "1986",
        "Animation, Action & Adventure, Sci-Fi & Fantasy",
        "81%",
        "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/t/p/w1280/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"))

        tvShow.add(
            TvShowEntity("t14",
                "Fairy Tail",
        "2009",
        "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
            "78%",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg"))

        tvShow.add(TvShowEntity("t15",
            "Family Guy",
        "1999",
        "Animation, Comedy",
        "70%",
        "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg"))

        tvShow.add(
            TvShowEntity("t16",
                "The Flash",
        "2014",
        "Drama, Sci-Fi & Fantasy",
            "77%",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )

        tvShow.add(TvShowEntity("t17",
            "Game of Thrones",
        "2011",
        "Sci-Fi & Fantasy, Drama, Action & Adventure",
        "84%",
        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://www.themoviedb.org/t/p/w1280/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"))

        tvShow.add(
            TvShowEntity("t18",
                    "Gotham",
        "2014",
        "Drama, Crime, Sci-Fi & Fantasy",
            "75%",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg")
        )

        tvShow.add(TvShowEntity("t19",
            "Grey's Anatomy",
        "2005",
        "Drama",
        "82%",
        "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"))

        tvShow.add(
            TvShowEntity("t20",
                "Hanna",
        "2019",
        "Action & Adventure, Drama",
            "75%",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "https://www.themoviedb.org/t/p/w1280/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg")
        )
        return tvShow
    }

    fun generateRemoteDummyMovies(): List<MovieResponse>{
        val movies = ArrayList<MovieResponse>()

        movies.add(
            MovieResponse("m11",
                "A Star is Born",
            "10/05/2018",
            "Drama, Romance, Music",
            "75%",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
        )

        movies.add(
            MovieResponse("m12",
                "Alita: Battle Angle",
            "02/14/2019",
            "Action, Science Fiction, Adventure",
            "72%",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg")
        )

        movies.add(
            MovieResponse("m13",
                "Aquaman",
                "12/21/2018",
                "Action, Adventure, Fantasy",
                "69%",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg")
        )

        movies.add(
            MovieResponse("m14",
                "Bohemian Rhapsody",
                "11/02/2018",
                "Music, Drama, History",
                "80%",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
        )

        movies.add(
            MovieResponse("m15",
                "Cold Pursuit",
                "02/08/2019",
                "Action, Crime, Thriller",
                "57%",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
        )

        movies.add(
            MovieResponse("m16",
                "Creed",
            "11/25/2015",
            "Drama",
            "74%",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            "https://www.themoviedb.org/t/p/w1280/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg")
        )

        movies.add(
            MovieResponse("m17",
                "Fantastic Beasts: The Crimes of Grindelwald",
            "11/16/2018",
            "Adventure, Fantasy, Drama",
            "69%",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg")
        )

        movies.add(
            MovieResponse("m18",
                "Glass",
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                "67%",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
        )

        movies.add(
            MovieResponse("m19",
                "How to Train Your Dragon",
            "03/26/2010",
            "Fantasy, Adventure, Animation, Family",
            "78%",
            "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
            "https://www.themoviedb.org/t/p/w1280/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg")
        )

        movies.add(
            MovieResponse("m20",
                "Avengers: Infinity War ",
            "04/27/2018",
            "Adventure, Action, Science Fiction",
            "83%",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg")
        )

        return movies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse>{
        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(
            TvShowResponse("t11",
                "Arrow",
            "2012",
            "Crime, Drama, Mystery, Action & Adventure",
            "66%",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
        )

        tvShow.add(
            TvShowResponse("t12",
                "Doom Patrol",
            "2019",
            "Sci-Fi & Fantasy, Comedy, Drama",
            "76%",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
        )

        tvShow.add(
            TvShowResponse("t13",
                "Dragon Ball",
            "1986",
            "Animation, Action & Adventure, Sci-Fi & Fantasy",
            "81%",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "https://www.themoviedb.org/t/p/w1280/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
        )

        tvShow.add(
            TvShowResponse("t14",
                "Fairy Tail",
                "2009",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "78%",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg")
        )

        tvShow.add(
            TvShowResponse("t15",
                "Family Guy",
            "1999",
            "Animation, Comedy",
            "70%",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg")
        )

        tvShow.add(
            TvShowResponse("t16",
                "The Flash",
                "2014",
                "Drama, Sci-Fi & Fantasy",
                "77%",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )

        tvShow.add(
            TvShowResponse("t17",
                "Game of Thrones",
            "2011",
            "Sci-Fi & Fantasy, Drama, Action & Adventure",
            "84%",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "https://www.themoviedb.org/t/p/w1280/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShow.add(
            TvShowResponse("t18",
                "Gotham",
                "2014",
                "Drama, Crime, Sci-Fi & Fantasy",
                "75%",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg")
        )

        tvShow.add(
            TvShowResponse("t19",
                "Grey's Anatomy",
            "2005",
            "Drama",
            "82%",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg")
        )

        tvShow.add(
            TvShowResponse("t20",
                "Hanna",
                "2019",
                "Action & Adventure, Drama",
                "75%",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "https://www.themoviedb.org/t/p/w1280/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg")
        )
        return tvShow
    }

//    fun generateRemoteDummyMoviesDetail(): List<DetailResponse>{
//        val movies = ArrayList<DetailResponse>()
//
//        movies.add(
//            DetailResponse("A Star is Born",
//                "10/05/2018",
//                "Drama, Romance, Music",
//                "75%",
//                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
//                "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Alita: Battle Angle",
//                "02/14/2019",
//                "Action, Science Fiction, Adventure",
//                "72%",
//                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
//                "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Aquaman",
//                "12/21/2018",
//                "Action, Adventure, Fantasy",
//                "69%",
//                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
//                "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Bohemian Rhapsody",
//                "11/02/2018",
//                "Music, Drama, History",
//                "80%",
//                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
//                "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Cold Pursuit",
//                "02/08/2019",
//                "Action, Crime, Thriller",
//                "57%",
//                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
//                "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Creed",
//                "11/25/2015",
//                "Drama",
//                "74%",
//                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
//                "https://www.themoviedb.org/t/p/w1280/iBq4od6j1ZAvDVO7hwmHT2Xf2Bt.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Fantastic Beasts: The Crimes of Grindelwald",
//                "11/16/2018",
//                "Adventure, Fantasy, Drama",
//                "69%",
//                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
//                "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg")
//        )
//
//        movies.add(
//           DetailResponse("Glass",
//                "01/18/2019",
//                "Thriller, Drama, Science Fiction",
//                "67%",
//                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
//                "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg")
//        )
//
//        movies.add(
//            DetailResponse("How to Train Your Dragon",
//                "03/26/2010",
//                "Fantasy, Adventure, Animation, Family",
//                "78%",
//                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
//                "https://www.themoviedb.org/t/p/w1280/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg")
//        )
//
//        movies.add(
//            DetailResponse("Avengers: Infinity War ",
//                "04/27/2018",
//                "Adventure, Action, Science Fiction",
//                "83%",
//                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
//                "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg")
//        )
//
//        return movies
//    }
//
//    fun generateRemoteDummyTvShowsDetail(): List<DetailResponse>{
//        val tvShow = ArrayList<DetailResponse>()
//
//        tvShow.add(
//            DetailResponse("Arrow",
//                "2012",
//                "Crime, Drama, Mystery, Action & Adventure",
//                "66%",
//                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
//                "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg")
//        )
//
//        tvShow.add(
//           DetailResponse("Doom Patrol",
//                "2019",
//                "Sci-Fi & Fantasy, Comedy, Drama",
//                "76%",
//                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
//                "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Dragon Ball",
//                "1986",
//                "Animation, Action & Adventure, Sci-Fi & Fantasy",
//                "81%",
//                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
//                "https://www.themoviedb.org/t/p/w1280/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Fairy Tail",
//                "2009",
//                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
//                "78%",
//                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
//                "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Family Guy",
//                "1999",
//                "Animation, Comedy",
//                "70%",
//                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
//                "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("The Flash",
//                "2014",
//                "Drama, Sci-Fi & Fantasy",
//                "77%",
//                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
//                "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Game of Thrones",
//                "2011",
//                "Sci-Fi & Fantasy, Drama, Action & Adventure",
//                "84%",
//                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
//                "https://www.themoviedb.org/t/p/w1280/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Gotham",
//                "2014",
//                "Drama, Crime, Sci-Fi & Fantasy",
//                "75%",
//                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
//                "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Grey's Anatomy",
//                "2005",
//                "Drama",
//                "82%",
//                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
//                "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg")
//        )
//
//        tvShow.add(
//            DetailResponse("Hanna",
//                "2019",
//                "Action & Adventure, Drama",
//                "75%",
//                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
//                "https://www.themoviedb.org/t/p/w1280/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg")
//        )
//        return tvShow
//    }

}