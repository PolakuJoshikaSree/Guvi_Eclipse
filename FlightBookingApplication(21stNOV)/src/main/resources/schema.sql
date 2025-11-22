CREATE TABLE IF NOT EXISTS airlines (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    airline_name VARCHAR(100),
    airline_code VARCHAR(50),
    country VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS flights (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(100),
    airline_code VARCHAR(50),
    from_place VARCHAR(100),
    to_place VARCHAR(100),
    flight_date DATE,
    departure_time TIME,
    arrival_time TIME,
    total_seats INT,
    booked_seats INT,
    price DOUBLE,
    meal_type_available VARCHAR(50),
    baggage_limit_kg DOUBLE
);

CREATE TABLE IF NOT EXISTS bookings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pnr VARCHAR(50),
    flight_id BIGINT,
    email VARCHAR(100),
    primary_passenger VARCHAR(100),
    seats_booked INT,
    booking_time TIMESTAMP,
    status VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS passengers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    passenger_name VARCHAR(100),
    gender VARCHAR(20),
    age INT,
    meal_preference VARCHAR(50),
    luggage_weight DOUBLE,
    booking_id BIGINT
);

CREATE TABLE IF NOT EXISTS payments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    payment_mode VARCHAR(50),
    payment_time TIMESTAMP,
    status VARCHAR(50),
    booking_id BIGINT
);

CREATE TABLE IF NOT EXISTS seats (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    seat_number VARCHAR(20),
    status VARCHAR(20),
    flight_id BIGINT
);
