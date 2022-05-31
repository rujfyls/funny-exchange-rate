package ru.feduncov.model;

import java.util.List;

public class GifResponse {
    private List<Data> data;

    public String getUrl() {
        return data.get(0).getImages().getOriginal().getUrl();
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {

        public Data() {
        }

        public Data(Images images) {
            this.images = images;
        }

        private Images images;

        private Images getImages() {
            return images;
        }

        private void setImages(Images images) {
            this.images = images;
        }

        public static class Images {
            private Original original;

            public Images() {
            }

            public Images(Original original) {
                this.original = original;
            }

            private Original getOriginal() {
                return original;
            }

            private void setOriginal(Original original) {
                this.original = original;
            }

            public static class Original {
                private String url;

                public Original() {
                }

                public Original(String url) {
                    this.url = url;
                }

                private String getUrl() {
                    return url;
                }

                private void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}

