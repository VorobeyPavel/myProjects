

        This is Spring Boot Rest project 
    ___________________________________________________________________________________________________________________

        Technology Used

    Spring Boot
    PostgreSQL  database
    Hibernate-validator
    Lombok
    Mockito
    ____________________________________________________________________________________________________________________
    
        How to start this project

    Create database intervale
    import schema.sql and data.sql

    ____________________________________________________________________________________________________________________

        Interaction with the service

    Get book, newspaper or magazine by id
    http://localhost:8088/api/book/{id}
    http://localhost:8088/api/newspaper/{id}
    http://localhost:8088/api/magazine/{id}
    ____________________________________________________________________________________________________________________

    Get all books, newspapers or magazines
    http://localhost:8088/api/all/books
    http://localhost:8088/api/all/newspapers
    http://localhost:8088/api/all/magazines
    ____________________________________________________________________________________________________________________

    Save book, newspaper or magazine
    http://localhost:8088/api/save/book
    http://localhost:8088/api/save/newspaper
    http://localhost:8088/api/save/magazine

    "name": "Song",
    "author": "Kupala",
    "releaseDate": "1910-10-18",
    "publisher": "Academy"
    ____________________________________________________________________________________________________________________

    Update book, newspaper or magazine
    http://localhost:8088/api/save/book
    http://localhost:8088/api/save/newspaper
    http://localhost:8088/api/save/magazine

    "id": 1,
    "name": "The Queen of Spades",
    "author": "Alexander Sergeyevich Pushkin",
    "releaseDate": "20.07.1833",
    "publisher": "Academy"
    ____________________________________________________________________________________________________________________

    Delete book, newspaper or magazine by id
    http://localhost:8088/api/book/{id}
    http://localhost:8088/api/newspaper/{id}
    http://localhost:8088/api/magazine/{id}
    ____________________________________________________________________________________________________________________
    