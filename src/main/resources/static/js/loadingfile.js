//모든 페이지에 공통 로드
document.addEventListener('DOMContentLoaded', function() {
  const overlay = document.getElementById('pageLoadingOverlay');

  // 새 페이지가 다 그려지면 로딩화면 숨기기
  window.addEventListener('load', function() {
    overlay.style.display = 'none';
  });

  // 페이지를 벗어나는 순간(링크 클릭, form 제출 등) 로딩화면 보이기
  window.addEventListener('beforeunload', function() {
    overlay.style.display = 'flex';
  });
});

// document.querySelectorAll('a[href]:not([target="_blank"])').forEach(link => {
//  link.addEventListener('click', function(e) {
    // 외부 링크나 #앵커는 제외하는 조건 추가 가능
//    overlay.style.display = 'flex';
//  });
// });
// <a> 태그 클릭에만 반응