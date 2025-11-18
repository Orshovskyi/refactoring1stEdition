package example.domain;

public class Movie {

    private final String title;
    private final MovieType priceCode;

    public enum MovieType {
        REGULAR {
            @Override
            public double calculateAmount(int days) {
                double result = 2;
                if (days > 2) {
                    result += (days - 2) * 1.5;
                }
                return result;
            }
        },
        NEW_RELEASE {
            @Override
            public double calculateAmount(int days) {
                return days * 3;
            }

            @Override
            public int bonusPoints(int days) {
                return days > 1 ? 2 : 1;
            }
        },
        CHILDRENS {
            @Override
            public double calculateAmount(int days) {
                double result = 1.5;
                if (days > 3) {
                    result += (days - 3) * 1.5;
                }
                return result;
            }
        };

        public double calculateAmount(int days) {
            return 0;
        }

        public int bonusPoints(int days) {
            return 1;
        }
    }

    public Movie(String title, MovieType priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public MovieType getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}