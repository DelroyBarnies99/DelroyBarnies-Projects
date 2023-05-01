const play_pause_button = document.getElementById("play-pause-button");
const mediaVideo = document.getElementById("media-video");

        function Play() {
            if(mediaVideo.paused){
                mediaVideo.play();
            }

            else{
                mediaVideo.pause();
            }
        };