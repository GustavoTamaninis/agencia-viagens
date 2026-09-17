ALTER TABLE public.destination_review
    DROP CONSTRAINT destination_review_destination_fkey;

ALTER TABLE public.destination_review
    ADD CONSTRAINT destination_review_destination_fkey
        FOREIGN KEY (destination_id)
        REFERENCES public.destination(id)
        ON DELETE CASCADE;
