using System;
using System.Collections.Generic;
using System.ComponentModel;
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

        private static readonly List<ListViewItemEx99> _lst = new List<ListViewItemEx99>();


        public ListViewItemEx99()
        {
            InitializeComponent();

            Loaded += ppLoaded;
            Unloaded += delegate
            {
                if (Content is BaseInfo bsi)
                {
                    //if (bsi.Num == "0027")
                    //{

                    //}
                }

                prPrintOut("Unloaded");
            };
        }

        private void ppLoaded(object sd, RoutedEventArgs ea)
        {
            //Loaded -= ppLoaded;

            if (Content is BaseInfo bsi)
            {
                if (bsi.Num == "0475")
                {

                }
            }

            if (m_bdrt == null)
            {
                m_bdrt = WpfElementHelper.FindChild<Border>(this, "_bdrt");
                m_gvrp = WpfElementHelper.FindChild<GridViewRowPresenter>(m_bdrt, null);
                m_ckb = WpfElementHelper.FindChild<CheckBox>(m_gvrp, "_ccb");

                _lst.Add(this);

                prCheckUpdateState();
            }
            else
            {
                prCheckUpdateState();
            }
        }

        private Border m_bdrt;
        private GridViewRowPresenter m_gvrp;
        private CheckBox m_ckb;

        private BaseInfo prGetBaseInfo()
        {
            return Content as BaseInfo;
        }
        #endregion


        private void prCheckUpdateState()
        {
            BaseInfo bsi = prGetBaseInfo();
            if (bsi != null)
            {
                bool b = bsi.Checked;
                if (b != IsSelected)
                {
                    IsSelected = b;
                    prPrintOut(">>> false");
                }
                else
                {
                    prSelectedAfterUpdate(IsSelected);
                    prPrintOut(">>> true");
                }
            }
        }

        private void prBaseInfoPropertyChangedCallback(string pnm)
        {
            if (pnm == "Checked")
            {
                if (Content is BaseInfo bsi)
                {
                    if (bsi.Num == "0266")
                    {

                    }
                }
                prCheckUpdateState();
            }
        }

        protected override void OnContentChanged(object oc, object nc)
        {
            prPrintOut("OnContentChanged");

            BaseInfo bsi = prGetBaseInfo();
            if (bsi != null)
            {
                //if (bsi.PropertyChangedCallback == null)
                //    bsi.PropertyChangedCallback = prBaseInfoPropertyChangedCallback;
                bsi.PropertyChangedCallback = prBaseInfoPropertyChangedCallback;
                prCheckUpdateState();
            }

            base.OnContentChanged(oc, nc);
        }

        private void prSelectedAfterUpdate(bool b)
        {
            if (b)
            {
                if (m_bdrt != null)
                {
                    m_bdrt.Background = Brushes.PeachPuff;
                    m_bdrt.BorderBrush = Brushes.DarkOrange;
                    m_ckb.IsChecked = true;
                }
            }
            else
            {
                if (m_bdrt != null)
                {
                    m_bdrt.Background = Brushes.Transparent;
                    m_bdrt.BorderBrush = Brushes.Transparent;
                    m_ckb.IsChecked = false;
                }
            }

            //if (b)
            //{
            //    Dispatcher.BeginInvoke(DispatcherPriority.Render,
            //        (Action)delegate
            //        {
            //            m_bdrt.Background = Brushes.PeachPuff;
            //            m_bdrt.BorderBrush = Brushes.DarkOrange;
            //            m_ckb.IsChecked = true;
            //        });
            //}
            //else
            //{
            //    Dispatcher.BeginInvoke(DispatcherPriority.Render,
            //        (Action)delegate
            //        {
            //            m_bdrt.Background = Brushes.Transparent;
            //            m_bdrt.BorderBrush = Brushes.Transparent;
            //            m_ckb.IsChecked = false;
            //        });
            //}
        }

        protected override void OnSelected(RoutedEventArgs ea)
        {
            prPrintOut("OnSelected");

            if (Content is BaseInfo bsi)
            {
                //if (bsi.Num == "0027")
                //{

                //}

                //prSelectedAfterUpdate(true);
                if (bsi.Checked == true)
                {
                    prSelectedAfterUpdate(true);
                }
                else
                {
                    bsi.Checked = true;
                }
            }

            base.OnSelected(ea);
        }

        protected override void OnUnselected(RoutedEventArgs ea)
        {
            prPrintOut("OnUnselected");

            if (Content is BaseInfo bsi)
            {
                //if (bsi.Num == "0027")
                //{

                //}

                //prSelectedAfterUpdate(false);
                if (bsi.Checked == false)
                {
                    prSelectedAfterUpdate(false);
                }
                else
                {
                    bsi.Checked = false;
                }
            }

            base.OnUnselected(ea);
        }

        public new bool IsSelected
        {
            get { return base.IsSelected; }
            set
            {
                base.IsSelected = value;
            }
        }



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //protected virtual void OnContentChanged(object oldContent, object newContent);
        //protected virtual void OnContentStringFormatChanged(string oldContentStringFormat, string newContentStringFormat);
        //protected virtual void OnContentTemplateChanged(DataTemplate oldContentTemplate, DataTemplate newContentTemplate);
        //protected virtual void OnContentTemplateSelectorChanged(DataTemplateSelector oldContentTemplateSelector, DataTemplateSelector newContentTemplateSelector);

        /*
        protected override void OnContentChanged(object oldContent, object newContent)
        {
            //prPrintOut("OnContentChanged");

            base.OnContentChanged(oldContent, newContent);
        }

        protected override void OnContentStringFormatChanged(string oldContentStringFormat, string newContentStringFormat)
        {
            //prPrintOut("OnContentStringFormatChanged");

            base.OnContentStringFormatChanged(oldContentStringFormat, newContentStringFormat);
        }

        protected override void OnContentTemplateChanged(DataTemplate oldContentTemplate, DataTemplate newContentTemplate)
        {
            //prPrintOut("OnContentTemplateChanged");

            base.OnContentTemplateChanged(oldContentTemplate, newContentTemplate);
        }

        protected override void OnContentTemplateSelectorChanged(DataTemplateSelector oldContentTemplateSelector, DataTemplateSelector newContentTemplateSelector)
        {
            //prPrintOut("OnContentTemplateSelectorChanged");

            base.OnContentTemplateSelectorChanged(oldContentTemplateSelector, newContentTemplateSelector);
        }
        */

    }
}
