CREATE TABLE public.destination(
    id bigserial NOT NULL,
    name varchar(255) NOT NULL,
    locate varchar(255) NOT NULL,
    travel_packets varchar(255) NOT NULL,
    hotel_availability boolean NOT NULL,
    description varchar(255) NOT NULL,
    tourist_activities varchar(255) NOT NULL,
    CONSTRAINT destination_pkey PRIMARY KEY (id)
);

CREATE TABLE public.destination_review(
    id bigserial NOT NULL,
    destination_id bigint NOT NULL,
    rating numeric(3, 2) NOT NULL,
    CONSTRAINT destination_review_pkey PRIMARY KEY (id),
    CONSTRAINT destination_review_destination_fkey
      FOREIGN KEY (destination_id)
          REFERENCES public.destination(id),
    CONSTRAINT destination_review_rating_check
      CHECK (rating >= 0 AND rating <= 5)
);
