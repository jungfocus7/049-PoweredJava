using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Threading;

namespace ExpansiveListViewExample
{
    public sealed partial class ListViewItemEx99 : ListViewItem
    {
        #region ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 0)
        private static void prPrintOut(string msg)
        {
            Debug.WriteLine(msg);
        }

        //private static readonly List<ListViewItemEx99> _lst = new List<ListViewItemEx99>();
        private static Brush m_brsbg;
        static ListViewItemEx99()
        {
            if (m_brsbg == null)
            {
                m_brsbg = Brushes.Magenta.Clone();
                m_brsbg.Opacity = 0.1;
            }
        }



        public ListViewItemEx99()
        {
            InitializeComponent();

            Loaded += ppLoaded;
            Unloaded += prUnloaded;

            //_lst.Add(this);
        }

        private void prUnloaded(object sd, RoutedEventArgs ea)
        {
            //Unloaded -= prUnloaded;
        }

        private void ppLoaded(object sd, RoutedEventArgs ea)
        {
            //Loaded -= ppLoaded;

            //if (m_bdrt == null) m_bdrt = WpfElementHelper.FindChild<Border>(this, "_bdrt");
            //if (m_gvrp == null) m_gvrp = WpfElementHelper.FindChild<GridViewRowPresenter>(m_bdrt, null);
            //if (m_ckb == null) m_ckb = WpfElementHelper.FindChild<CheckBox>(m_gvrp, "_ccb");
        }

        private Border m_bdrt;
        private Border _border
        {
            get
            {
                if (m_bdrt == null)
                    m_bdrt = WpfElementHelper.FindChild<Border>(this, "_bdrt");
                return m_bdrt;
            }
        }
        //private GridViewRowPresenter m_gvrp;
        private CheckBox m_ckb;
        private CheckBox _checkBox
        {
            get
            {
                if (m_ckb == null)
                    m_ckb = WpfElementHelper.FindChild<CheckBox>(this, "_ccb");
                return m_ckb;
            }
        }

        public BaseInfo GetBaseInfo()
        {
            return Content as BaseInfo;
        }
        #endregion

        
        private void prSelectedAfterUpdate(bool b)
        {
            if (b)
            {
                _border.Background = m_brsbg;
                _border.BorderBrush = Brushes.DarkOrange;
                _checkBox.IsChecked = true;

                //Dispatcher.BeginInvoke(DispatcherPriority.Render,
                //    (Action)delegate
                //    {
                //        m_bdrt.Background = m_brsbg;
                //        m_bdrt.BorderBrush = Brushes.DarkOrange;
                //        m_ckb.IsChecked = true;
                //    });
            }
            else
            {
                _border.Background = Brushes.Transparent;
                _border.BorderBrush = Brushes.Transparent;
                _checkBox.IsChecked = false;

                //Dispatcher.BeginInvoke(DispatcherPriority.Render,
                //    (Action)delegate
                //    {
                //        m_bdrt.Background = Brushes.Transparent;
                //        m_bdrt.BorderBrush = Brushes.Transparent;
                //        m_ckb.IsChecked = false;
                //    });
            }
        }

        protected override void OnSelected(RoutedEventArgs ea)
        {
            //prPrintOut("OnSelected");

            prSelectedAfterUpdate(true);

            base.OnSelected(ea);
        }

        protected override void OnUnselected(RoutedEventArgs ea)
        {
            //prPrintOut("OnUnselected");

            prSelectedAfterUpdate(false);

            base.OnUnselected(ea);
        }






        //protected override void OnPreviewMouseLeftButtonDown(MouseButtonEventArgs ea)
        //{
        //    ea.Handled = true;

        //    bool b = IsSelected;
        //    IsSelected = !b;

        //    base.OnPreviewMouseLeftButtonDown(ea);
        //}


        //public new bool IsSelected { get; set; }

        //protected override void OnSelected(RoutedEventArgs ea)
        //{
        //    base.OnSelected(ea);
        //    //prPrintOut("OnSelected");

        //    prSelectedAfterUpdate(true);

        //    //base.OnSelected(ea);
        //}

        //protected override void OnUnselected(RoutedEventArgs ea)
        //{
        //    base.OnUnselected(ea);
        //    //prPrintOut("OnUnselected");

        //    prSelectedAfterUpdate(false);

        //    //base.OnUnselected(ea);
        //}



    }
}
