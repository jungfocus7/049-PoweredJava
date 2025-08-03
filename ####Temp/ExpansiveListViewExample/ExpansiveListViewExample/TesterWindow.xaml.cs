using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;


namespace ExpansiveListViewExample
{
    public sealed partial class TesterWindow : Window
    {
        public TesterWindow()
        {
            InitializeComponent();

            Loaded += prLoaded;
        }

        protected override void OnContentRendered(EventArgs ea)
        {
            base.OnContentRendered(ea);

            SizeToContent = SizeToContent.Manual;
            _grdrt.Width = double.NaN;
            _grdrt.Height = double.NaN;
        }

        private void prRemoveItems(int l)
        {
            if (l < 1) l = 100;

            int c = CommonHelper.BaseInfos.Count;
            if (c == 0) return;

            int m = (l > c) ? 0 : c - l;
            int i = (c > 0) ? --c : 0;//last index
            while (i >= m)
            {
                CommonHelper.BaseInfos.RemoveAt(i--);
            }
        }

        private void prAddItems(int l)
        {
            if (l < 1) l = 100;

            int c = CommonHelper.BaseInfos.Count;
            for (int i = 0; i < l; i++)
            {
                CommonHelper.BaseInfos.Add(
                    new BaseInfo()
                    {
                        Checked = false,
                        Num = (++c).ToString().PadLeft(7, '0'),
                        Name = "박종명",
                        Age = "37",
                        Job = "유통업",
                        Address = "서울시 강동구 암사동 892-24 청원빌라 205호",
                    });
            }
        }

        private void prLoaded(object sd, RoutedEventArgs ea)
        {
            Loaded -= prLoaded;


            prAddItems(1000000);

            // 몇개 삭제
            _btn34.Click += delegate
            {
                _lst31.UnselectAll();
                prRemoveItems(100000);
            };

            // 몇개 추가
            _btn33.Click += delegate
            {
                _lst31.UnselectAll();
                prAddItems(500000);
            };

            // 모두 선택
            _btn32.Click += delegate
            {
                _lst31.SelectAll();
            };

            // 선택 해제
            _btn31.Click += delegate
            {
                _lst31.UnselectAll();
            };
        }

        //protected override void OnKeyDown(KeyEventArgs ea)
        //{
        //    base.OnKeyDown(ea);

        //    if (ea.Key == Key.Q)
        //    {
        //        //_lst31.PrevSelectedGotoView();
        //    }
        //    else if (ea.Key == Key.A)
        //    {
        //        //_lst31.NextSelectedGotoView();
        //    }
        //}

    }
}
